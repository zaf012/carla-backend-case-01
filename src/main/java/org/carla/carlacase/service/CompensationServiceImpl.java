package org.carla.carlacase.service;

import java.util.List;
import org.carla.carlacase.domain.Company;
import org.carla.carlacase.domain.Compensation;
import org.carla.carlacase.domain.Employee;
import org.carla.carlacase.domain.Employment;
import org.carla.carlacase.domain.Position;
import org.carla.carlacase.integration.CompensationDataIntegrationService;
import org.carla.carlacase.integration.model.CompensationData;
import org.carla.carlacase.repository.CompanyRepository;
import org.carla.carlacase.repository.CompensationRepository;
import org.carla.carlacase.repository.CompensationSelectionModel;
import org.carla.carlacase.repository.EmployeeRepository;
import org.carla.carlacase.repository.EmploymentRepository;
import org.carla.carlacase.repository.PositionRepository;
import org.carla.carlacase.service.base.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CompensationServiceImpl implements CompensationService {

  private static final Logger log = LoggerFactory.getLogger(CompensationServiceImpl.class);
  private final CompensationRepository compensationRepository;
  private final CompanyRepository companyRepository;
  private final EmployeeRepository employeeRepository;
  private final EmploymentRepository employmentRepository;
  private final PositionRepository positionRepository;

  private final CompensationDataIntegrationService compensationDataIntegrationService;


  public CompensationServiceImpl(CompensationRepository compensationRepository,
      CompanyRepository companyRepository, EmployeeRepository employeeRepository,
      EmploymentRepository employmentRepository, PositionRepository positionRepository,
      CompensationDataIntegrationService compensationDataIntegrationService) {
    this.compensationRepository = compensationRepository;
    this.companyRepository = companyRepository;
    this.employeeRepository = employeeRepository;
    this.employmentRepository = employmentRepository;
    this.positionRepository = positionRepository;
    this.compensationDataIntegrationService = compensationDataIntegrationService;

  }

  @Transactional
  @Override
  public void loadIntegrationData() {

    List<CompensationData> compensationData = compensationDataIntegrationService.readCompensationDataFromCsv();
    compensationData.forEach(data -> {
      try {
        Employee employee = new Employee();
        employee.setGender(data.getGender());
        String employeeId = employeeRepository.saveAndFlush(employee).getId();

        Company company = new Company();
        company.setName(data.getEmployer());
        company.setLocation(data.getLocation());
        String companyId = companyRepository.saveAndFlush(company).getId();

        Position position = new Position();
        position.setTitle(data.getJobTitle());
        String positionId = positionRepository.saveAndFlush(position).getId();

        Employment employment = new Employment();
        employment.setCompanyId(companyId);
        employment.setEmployeeId(employeeId);
        employment.setPositionId(positionId);
        employment.setYearsAtEmployer(data.getYearsAtEmployer());

        String employmentId = employmentRepository.saveAndFlush(employment).getId();

        Compensation compensation = new Compensation();
        compensation.setAnnualBonus(data.getAnnualBonus());
        compensation.setTimestamp(data.getDate());
        compensation.setAdditionalComments(data.getAdditionalComments());
        compensation.setSigningBonus(data.getSigningBonus());
        compensation.setAnnualBasePay(data.getAnnualBasePay());
        compensation.setAnnualStockValueBonus(data.getAnnualStockValueBonus());
        compensation.setEmploymentId(employmentId);

        compensationRepository.saveAndFlush(compensation);
      } catch (Exception e) {
        log.error("Error loading compensation data", e);
        throw new RuntimeException(e);
      }
    });
  }

  @Override
  public Double getEngineerAvgSalary() {
    return compensationRepository.findAvgEngineerSalary();
  }

  @Override
  public List<CompensationSelectionModel> getAvgMinMaxSalariesByLocation() {
    return compensationRepository.findAvgMinAndMaxSalaryByLocation();
  }

  @Override
  public List<CompensationSelectionModel> getMinMaxSalariesByGender() {
    List<CompensationSelectionModel> avgMinAndMaxSalaryByGender = compensationRepository.findAvgMinAndMaxSalaryByGender();
    return compensationRepository.findAvgMinAndMaxSalaryByGender();
  }

}
