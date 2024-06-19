package org.carla.carlacase.service.base;

import java.util.List;
import org.carla.carlacase.repository.CompensationSelectionModel;
import org.springframework.transaction.annotation.Transactional;

public interface CompensationService {

  @Transactional
  void loadIntegrationData();

  Double getEngineerAvgSalary();

  List<CompensationSelectionModel> getAvgMinMaxSalariesByLocation();

  List<CompensationSelectionModel> getMinMaxSalariesByGender();
}
