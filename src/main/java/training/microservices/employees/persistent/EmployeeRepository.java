package training.microservices.employees.persistent;

import java.util.Collection;

import training.microservices.employees.dto.EmployeeDto;

public interface EmployeeRepository {

    EmployeeDto create(EmployeeDto newEmployee);

    EmployeeDto update(EmployeeDto newEmployee);

    boolean delete(Long employeeId);

    Collection<EmployeeDto> findAllEmployees();

    EmployeeDto findWithDevices(Long id);
}
