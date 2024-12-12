package training.microservices.employees.persistent.mysql;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.microservices.employees.dto.EmployeeDto;
import training.microservices.employees.persistent.EmployeeRepository;
import training.microservices.employees.persistent.mysql.entity.Employee;
import training.microservices.employees.persistent.mysql.mapper.EmployeeEntityMapper;
import training.microservices.employees.persistent.mysql.repository.JpaEmployeeRepository;

@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class BusinessBridge implements EmployeeRepository {

    private final JpaEmployeeRepository jpaRepository;

    private final EmployeeEntityMapper mapper;

    @Override
    public EmployeeDto create(EmployeeDto newEmployee) {
        Employee employeeEntity = mapper.toEntity(newEmployee);
        employeeEntity.setId(null);
        Employee savedEntity = jpaRepository.save(employeeEntity);
        return mapper.toBusinessDto(savedEntity);
    }

    @Override
    public EmployeeDto update(EmployeeDto newEmployee) {
        Employee employee = jpaRepository.findById(newEmployee.getId())
            .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + newEmployee.getId()));
        employee.setSurname(newEmployee.getSurname());
        employee.setLastname(newEmployee.getLastname());
        employee.setLastname2(newEmployee.getLastname2());
        employee.setDateOfBirth(newEmployee.getDateOfBirth());
        Employee updatedEmployee = jpaRepository.save(employee);
        return mapper.toBusinessDto(updatedEmployee);
    }

    @Override
    public boolean delete(Long employeeId) {
        jpaRepository.findById(employeeId).orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + employeeId));
        jpaRepository.deleteById(employeeId);
        Optional<Employee> oldEmployee = jpaRepository.findById(employeeId);
        return oldEmployee.isEmpty();
    }

    @Override
    public Collection<EmployeeDto> findAllEmployees() {
        List<Employee> employees = jpaRepository.findAll();
        employees.forEach(e -> e.setDevices(null));
        return employees.stream().map(mapper::toBusinessDto).toList();
    }

    @Override
    public EmployeeDto findWithDevices(Long id) {
        return jpaRepository.findById(id).map(mapper::toBusinessDto).orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + id));
    }
}
