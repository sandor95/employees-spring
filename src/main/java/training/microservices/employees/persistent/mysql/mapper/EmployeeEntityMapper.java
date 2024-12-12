package training.microservices.employees.persistent.mysql.mapper;

import org.mapstruct.Mapper;
import training.microservices.employees.dto.EmployeeDto;
import training.microservices.employees.persistent.mysql.entity.Employee;

@Mapper(componentModel = "spring", uses = DeviceEntityMapper.class)
public interface EmployeeEntityMapper {

    EmployeeDto toBusinessDto(Employee employee);

    Employee toEntity(EmployeeDto employeeDto);
}
