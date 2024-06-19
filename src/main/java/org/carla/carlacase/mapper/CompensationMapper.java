package org.carla.carlacase.mapper;

import java.util.List;
import org.carla.carlacase.domain.Compensation;
import org.carla.carlacase.dto.CompensationDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CompensationMapper {

  Compensation convertFromDtoToEntity(CompensationDTO request);

  CompensationDTO convertFromEntityToDto(Compensation request);

  List<Compensation> convertAllFromDtoToEntity(List<CompensationDTO> request);

  List<CompensationDTO> convertAllFromEntityToDto(List<Compensation> request);


}
