package training.microservices.employees.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import training.microservices.employees.dto.EmployeeDto;
import training.microservices.employees.openapi.model.EmployeeApiDto;

@Mapper(componentModel = "spring", uses = DeviceMapper.class)
public interface EmployeeMapper {

    @Mapping(target = "surname", expression = "java(MapperUtil.normalize(employeeApiDto.getSurname()))")
    @Mapping(target = "lastname", expression = "java(MapperUtil.normalize(employeeApiDto.getLastname()))")
    @Mapping(target = "lastname2", expression = "java(MapperUtil.normalize(employeeApiDto.getLastname2()))")
    EmployeeDto toBusinessDto(EmployeeApiDto employeeApiDto);

    EmployeeApiDto toApiDto(EmployeeDto employeeDto);

}
