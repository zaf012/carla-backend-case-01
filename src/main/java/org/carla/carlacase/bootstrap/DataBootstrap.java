package org.carla.carlacase.bootstrap;

import java.util.List;
import org.carla.carlacase.integration.CompensationDataIntegrationService;
import org.carla.carlacase.repository.CompensationSelectionModel;
import org.carla.carlacase.service.CompensationServiceImpl;
import org.carla.carlacase.service.base.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class DataBootstrap implements CommandLineRunner {

/*  @Autowired
  private CompensationService service;*/

  @Override
  public void run(String... strings) throws Exception {
    //service.getMinMaxSalariesByGender();

  }
}
