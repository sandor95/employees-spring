package training.microservices.employees.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import training.microservices.employees.dto.DeviceDto;
import training.microservices.employees.openapi.model.DeviceApiDto;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    @Mapping(target = "name", expression = "java(MapperUtil.normalize(deviceApiDto.getName()))")
    @Mapping(target = "details", expression = "java(MapperUtil.normalize(deviceApiDto.getDetails()))")
    DeviceDto toBusinessDto(DeviceApiDto deviceApiDto);

}
