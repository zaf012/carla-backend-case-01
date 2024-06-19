package org.carla.carlacase.controller;

import org.carla.carlacase.service.base.CompensationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compensation_data")
public class CompensationController {

  private final CompensationService compensationService;

  public CompensationController(CompensationService compensationService) {
    this.compensationService = compensationService;
  }

  @GetMapping("/get-engineer-avg-salary")
  public Double getAvgSalaryForEngineer() {
    return compensationService.getEngineerAvgSalary();
  }
}
