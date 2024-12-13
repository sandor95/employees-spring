package training.microservices.employees.api.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import training.microservices.employees.dto.EmployeeDto;
import training.microservices.employees.openapi.model.EmployeeApiDto;

@Mapper(componentModel = "spring", uses = DeviceRestMapper.class)
public interface EmployeeRestMapper {

    @Mapping(target = "surname", expression = "java(training.microservices.employees.mapper.MapperUtil.normalize(employeeApiDto.getSurname()))")
    @Mapping(target = "lastname", expression = "java(training.microservices.employees.mapper.MapperUtil.normalize(employeeApiDto.getLastname()))")
    @Mapping(target = "lastname2", expression = "java(training.microservices.employees.mapper.MapperUtil.normalize(employeeApiDto.getLastname2()))")
    EmployeeDto toBusinessDto(EmployeeApiDto employeeApiDto);

    EmployeeApiDto toApiDto(EmployeeDto employeeDto);

}
