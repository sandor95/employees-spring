package training.microservices.employees.service;

import java.util.Collection;

import training.microservices.employees.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto newEmployee);

    EmployeeDto delete(Long employeeId);

    EmployeeDto getEmployee(Long id);

    Collection<EmployeeDto> getAll();
}
