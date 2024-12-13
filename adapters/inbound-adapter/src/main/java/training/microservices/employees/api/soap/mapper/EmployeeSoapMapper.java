package training.microservices.employees.api.soap.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import training.microservices.employees.dto.EmployeeDto;
import com.training.microservices.emptrack.employees.EmployeeApiDto;

@Mapper(componentModel = "spring", uses = DeviceSoapMapper.class)
public interface EmployeeSoapMapper {

    @Mapping(target = "surname", expression = "java(training.microservices.employees.mapper.MapperUtil.normalize(employeeApiDto.getSurname()))")
    @Mapping(target = "lastname", expression = "java(training.microservices.employees.mapper.MapperUtil.normalize(employeeApiDto.getLastname()))")
    @Mapping(target = "lastname2", expression = "java(training.microservices.employees.mapper.MapperUtil.normalize(employeeApiDto.getLastname2()))")
    EmployeeDto toBusinessDto(EmployeeApiDto employeeApiDto);

    EmployeeApiDto toApiDto(EmployeeDto employeeDto);

}
