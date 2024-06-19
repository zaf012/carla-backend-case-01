package org.carla.carlacase.json_converter;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.carla.carlacase.dto.CompensationDTO;


public class JsonConverter {

  public static List<CompensationDTO> convertJsonToCompensationDTOList(String filePath)
      throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    // read Json file and convert to DTO
    return objectMapper.readValue(new File(filePath), new TypeReference<List<CompensationDTO>>() {
    });
  }

}
