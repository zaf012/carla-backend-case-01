package org.carla.carlacase.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EMPLOYMENT")
public class Employment {


  @Id
  @Column(name = "ID")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private String id;

  @Column(name = "EMPLOYEE_ID")
  private String employeeId;

  @Column(name = "POSITION_ID")
  private String positionId;

  @Column(name = "COMPANY_ID")
  private String companyId;

  @Column(name = "YEARS_AT_EMPLOYER")
  private String yearsAtEmployer;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public String getPositionId() {
    return positionId;
  }

  public void setPositionId(String positionId) {
    this.positionId = positionId;
  }

  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  public String getYearsAtEmployer() {
    return yearsAtEmployer;
  }

  public void setYearsAtEmployer(String yearsAtEmployer) {
    this.yearsAtEmployer = yearsAtEmployer;
  }
}
