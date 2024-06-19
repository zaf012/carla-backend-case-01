package org.carla.carlacase.integration;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.carla.carlacase.integration.model.CompensationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CompensationDataIntegrationService {

  private static final Logger log = LoggerFactory.getLogger(
      CompensationDataIntegrationService.class);

  public List<CompensationData> readCompensationDataFromCsv() {

    Resource resource = new ClassPathResource("compensation_dataset/salary_survey-3.csv");
    Path filePath = null;

    try {
      filePath = Paths.get(resource.getURI());
    } catch (IOException e) {
      e.printStackTrace();
    }

    List<CompensationData> compensationDataList = new ArrayList<>();

    try (Reader reader = Files.newBufferedReader(filePath)) {
      Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(reader);
      for (CSVRecord record : records) {

        String timestamp = record.get("Timestamp");
        if (!StringUtils.hasText(timestamp)) {
          continue;
        }

        Double annualBasePay;
        try {
          annualBasePay = Double.parseDouble(record.get("Annual Base Pay"));
        } catch (Exception e) {
          log.error("Error parsing annual base pay");
          continue;
        }

        CompensationData compensationData = new CompensationData();
        compensationData.setTimestamp(record.get("Timestamp"));
        //compensationData.setDate(DateFormatter.formatDate(timestamp));
        compensationData.setEmployer(record.get("Employer"));
        compensationData.setLocation(record.get("Location"));
        compensationData.setJobTitle(record.get("Job Title"));
        compensationData.setYearsAtEmployer(record.get("Years at Employer"));
        compensationData.setYearsOfExperience(record.get("Years of Experience"));
        compensationData.setAnnualBasePay(String.valueOf(annualBasePay));
        compensationData.setSigningBonus(record.get("Signing Bonus"));
        compensationData.setAnnualBonus(record.get("Annual Bonus"));
        compensationData.setAnnualStockValueBonus(record.get("Annual Stock Value/Bonus"));
        compensationData.setGender(record.get("Gender"));
        compensationData.setAdditionalComments(record.get("Additional Comments"));
        compensationDataList.add(compensationData);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return compensationDataList;
  }
}
