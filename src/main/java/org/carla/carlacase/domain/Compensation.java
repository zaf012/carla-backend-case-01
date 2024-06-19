package org.carla.carlacase.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "COMPENSATION")
public class Compensation {

  @Id
  @Column(name = "ID")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private String id;

  @Column(name = "EMPLOYMENT_ID")
  private String employmentId;

  @Column(name = "TIMESTAMP")
  private String timestamp;

  @Column(name = "SIGNINGBONUS")
  private String signingBonus;

  @Column(name = "ANNUALBONUS")
  private String annualBonus;

  @Column(name = "ANNUALSTOCKVALUEBONUS")
  private String annualStockValueBonus;

  @Column(name = "ANNUALBASEPAY")
  private String annualBasePay;

  @Column(name = "ADDITIONALCOMMENTS", columnDefinition = "TEXT")
  private String additionalComments;

  public String getEmploymentId() {

    return employmentId;
  }

  public void setEmploymentId(String employmentId) {
    this.employmentId = employmentId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
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

  public String getAdditionalComments() {
    return additionalComments;
  }

  public void setAdditionalComments(String additionalComments) {
    this.additionalComments = additionalComments;
  }

  public String getAnnualBasePay() {
    return annualBasePay;
  }

  public void setAnnualBasePay(String annualBasePay) {
    this.annualBasePay = annualBasePay;
  }
}

