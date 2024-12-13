package training.microservices.employees.api.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import training.microservices.employees.dto.DeviceDto;
import training.microservices.employees.openapi.model.DeviceApiDto;

@Mapper(componentModel = "spring")
public interface DeviceRestMapper {

    @Mapping(target = "name", expression = "java(training.microservices.employees.mapper.MapperUtil.normalize(deviceApiDto.getName()))")
    @Mapping(target = "details", expression = "java(training.microservices.employees.mapper.MapperUtil.normalize(deviceApiDto.getDetails()))")
    DeviceDto toBusinessDto(DeviceApiDto deviceApiDto);

}
