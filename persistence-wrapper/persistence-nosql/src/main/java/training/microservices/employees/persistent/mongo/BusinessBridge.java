package training.microservices.employees.persistent.mongo;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import training.microservices.employees.dto.EmployeeDto;
import training.microservices.employees.persistent.EmployeeRepository;

@Service
public class BusinessBridge implements EmployeeRepository {

    @Override
    public EmployeeDto create(EmployeeDto newEmployee) {
        return null;
    }

    @Override
    public EmployeeDto update(EmployeeDto newEmployee) {
        return null;
    }

    @Override
    public boolean delete(Long employeeId) {
        return false;
    }

    @Override
    public Collection<EmployeeDto> findAllEmployees() {
        return List.of();
    }

    @Override
    public EmployeeDto findWithDevices(Long id) {
        return null;
    }
}
