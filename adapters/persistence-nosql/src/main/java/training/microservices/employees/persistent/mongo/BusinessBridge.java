package training.microservices.employees.persistent.mongo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import training.microservices.employees.dto.EmployeeDto;
import training.microservices.employees.persistent.EmployeeRepository;
import training.microservices.employees.persistent.mongo.entity.Employee;
import training.microservices.employees.persistent.mongo.mapper.EmployeeEntityMapper;
import training.microservices.employees.persistent.mongo.repository.MongoEmployeeRepository;

@Service
@RequiredArgsConstructor
public class BusinessBridge implements EmployeeRepository {

    private final EmployeeEntityMapper mapper;

    private final MongoEmployeeRepository mongoRepository;

    @Override
    public EmployeeDto create(EmployeeDto newEmployee) {
        Employee employeeEntity = mapper.toEntity(newEmployee);
        employeeEntity.setId(null);
        Employee savedEntity = mongoRepository.save(employeeEntity);
        return mapper.toBusinessDto(savedEntity);
    }

    @Override
    public EmployeeDto update(EmployeeDto newEmployee) {
        Employee employee = mongoRepository.findById(String.valueOf(newEmployee.getId()))
            .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + newEmployee.getId()));
        employee.setSurname(newEmployee.getSurname());
        employee.setLastname(newEmployee.getLastname());
        employee.setLastname2(newEmployee.getLastname2());
        employee.setDateOfBirth(newEmployee.getDateOfBirth());
        Employee updatedEmployee = mongoRepository.save(employee);
        return mapper.toBusinessDto(updatedEmployee);
    }

    @Override
    public boolean delete(Long employeeId) {
        String id = String.valueOf(employeeId);
        mongoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + employeeId));
        mongoRepository.deleteById(id);
        Optional<Employee> oldEmployee = mongoRepository.findById(id);
        return oldEmployee.isEmpty();
    }

    @Override
    public Collection<EmployeeDto> findAllEmployees() {
        List<Employee> employees = mongoRepository.findAll();
        employees.forEach(e -> e.setDevices(null));
        return employees.stream().map(mapper::toBusinessDto).toList();
    }

    @Override
    public EmployeeDto findWithDevices(Long id) {
        String employeeId = String.valueOf(id);
        return mongoRepository.findById(employeeId).map(mapper::toBusinessDto).orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + id));
    }
}
