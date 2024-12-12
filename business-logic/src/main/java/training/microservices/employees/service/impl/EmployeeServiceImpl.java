package training.microservices.employees.service.impl;

import java.util.Collection;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.microservices.employees.dto.EmployeeDto;
import training.microservices.employees.persistent.EmployeeRepository;
import training.microservices.employees.service.EmployeeService;

@Slf4j
@Valid
@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto create(@NotNull(message = "Cannot create employee from null parameter") EmployeeDto employeeDto) {
        Objects.requireNonNull(employeeDto, "Cannot create employee from null parameter");
        // NOTE: should run business validations
        log.info("Creating employee: {}", employeeDto);
        return employeeRepository.create(employeeDto);
    }

    @Override
    public EmployeeDto update(@NotNull(message = "Cannot update employee from null parameter") EmployeeDto newEmployee) {
        Objects.requireNonNull(newEmployee.getId(), "Employee ID is null");
        // NOTE: should run business validation and compare data then
        log.info("Updating employee: {}", newEmployee);
        return employeeRepository.update(newEmployee);
    }

    @Override
    public EmployeeDto delete(@NotNull(message = "Employee ID is null") Long employeeId) {
        EmployeeDto employee = employeeRepository.findWithDevices(employeeId);
        boolean deleted = employeeRepository.delete(employeeId);
        if (deleted) {
            log.info("Deleted employee: {}", employee);
        } else {
            log.info("Employee delete failed with id: {}", employeeId);
        }
        return deleted ? employee : null;
    }

    @Override
    public EmployeeDto getEmployee(@NotNull(message = "Employee ID is null")Long id) {
        log.info("Searching employee by id: {}", id);
        return employeeRepository.findWithDevices(id);
    }

    @Override
    public Collection<EmployeeDto> getAll() {
        log.info("Querying all employees...");
        Collection<EmployeeDto> employees = employeeRepository.findAllEmployees();
        // NOTE: we don't need devices here
        employees.forEach(employee -> employee.setDevices(null));
        return employees;
    }

}
