package org.carla.carlacase.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

  @Id
  @Column(name = "ID")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private String id;

  @Column(name = "GENDER")
  private String gender;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

}
