package training.microservices.employees.persistent.mongo.mapper;

import org.mapstruct.Mapper;
import training.microservices.employees.dto.DeviceDto;
import training.microservices.employees.persistent.mongo.entity.Device;

@Mapper(componentModel = "spring")
public interface DeviceEntityMapper {

    DeviceDto toBusinessDto(Device device);

    Device toEntity(DeviceDto deviceDto);
}
