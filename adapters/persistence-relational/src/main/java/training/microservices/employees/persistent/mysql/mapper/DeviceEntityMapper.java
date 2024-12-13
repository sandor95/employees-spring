package training.microservices.employees.persistent.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import training.microservices.employees.dto.DeviceDto;
import training.microservices.employees.persistent.mysql.entity.Device;

@Mapper(componentModel = "spring")
public interface DeviceEntityMapper {

    @Mapping(target = "employeeId", expression = "java(device.getEmployee().getId())")
    DeviceDto toBusinessDto(Device device);

    @Mapping(target = "employee", ignore = true)
    Device toEntity(DeviceDto deviceDto);
}
