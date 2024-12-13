package training.microservices.employees.api.soap.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import training.microservices.employees.dto.DeviceDto;
import com.training.microservices.emptrack.employees.DeviceApiDto;

@Mapper(componentModel = "spring")
public interface DeviceSoapMapper {

    @Mapping(target = "name", expression = "java(training.microservices.employees.mapper.MapperUtil.normalize(deviceApiDto.getName()))")
    @Mapping(target = "details", expression = "java(training.microservices.employees.mapper.MapperUtil.normalize(deviceApiDto.getDetails()))")
    DeviceDto toBusinessDto(DeviceApiDto deviceApiDto);

}
