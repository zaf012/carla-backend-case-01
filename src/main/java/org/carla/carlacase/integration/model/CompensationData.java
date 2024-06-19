package org.carla.carlacase.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompensationData {

  @JsonProperty("Timestamp")
  private String timestamp;

  @JsonProperty("Date")
  private String date;


  @JsonProperty("Employer")
  private String employer;

  @JsonProperty("Location")
  private String location;

  @JsonProperty("Job Title")
  private String jobTitle;

  @JsonProperty("Years at Employer")
  private String yearsAtEmployer;

  @JsonProperty("Years of Experience")
  private String yearsOfExperience;

  @JsonProperty("Annual Base Pay")
  private String annualBasePay;

  @JsonProperty("Signing Bonus")
  private String signingBonus;

  @JsonProperty("Annual Bonus")
  private String annualBonus;

  @JsonProperty("Annual Stock Value/Bonus")
  private String annualStockValueBonus;

  @JsonProperty("Gender")
  private String gender;

  @JsonProperty("Additional Comments")
  private String additionalComments;

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getEmployer() {
    return employer;
  }

  public void setEmployer(String employer) {
    this.employer = employer;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public String getYearsAtEmployer() {
    return yearsAtEmployer;
  }

  public void setYearsAtEmployer(String yearsAtEmployer) {
    this.yearsAtEmployer = yearsAtEmployer;
  }

  public String getYearsOfExperience() {
    return yearsOfExperience;
  }

  public void setYearsOfExperience(String yearsOfExperience) {
    this.yearsOfExperience = yearsOfExperience;
  }

  public String getAnnualBasePay() {
    return annualBasePay;
  }

  public void setAnnualBasePay(String annualBasePay) {
    this.annualBasePay = annualBasePay;
  }

  public String getSigningBonus() {
    return signingBonus;
  }

  public void setSigningBonus(String signingBonus) {
    this.signingBonus = signingBonus;
  }

  public String getAnnualBonus() {
    return annualBonus;
  }

  public void setAnnualBonus(String annualBonus) {
    this.annualBonus = annualBonus;
  }

  public String getAnnualStockValueBonus() {
    return annualStockValueBonus;
  }

  public void setAnnualStockValueBonus(String annualStockValueBonus) {
    this.annualStockValueBonus = annualStockValueBonus;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAdditionalComments() {
    return additionalComments;
  }

  public void setAdditionalComments(String additionalComments) {
    this.additionalComments = additionalComments;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
