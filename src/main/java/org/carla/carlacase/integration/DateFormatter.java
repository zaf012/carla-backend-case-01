package org.carla.carlacase.integration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

  public static String formatDate(String dateString) {

    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("M/d/yyyy h:m:s a");


    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    LocalDate date = LocalDate.parse(dateString, inputFormatter);

    return date.format(outputFormatter);
  }

}
