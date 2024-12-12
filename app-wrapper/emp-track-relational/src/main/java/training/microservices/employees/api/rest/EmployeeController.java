package training.microservices.employees.api.rest;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.microservices.employees.dto.EmployeeDto;
import training.microservices.employees.mapper.EmployeeMapper;
import training.microservices.employees.openapi.controller.EmployeesApi;
import training.microservices.employees.openapi.model.EmployeeApiDto;
import training.microservices.employees.service.EmployeeService;

@RestController
@RequestMapping
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class EmployeeController implements EmployeesApi {

    private final EmployeeMapper employeeMapper;

    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<EmployeeApiDto> createEmployee(EmployeeApiDto employeeApiDto) {
        EmployeeApiDto newApiDto = Optional.ofNullable(employeeApiDto)
                                            .map(employeeMapper::toBusinessDto)
                                            .map(employeeService::create)
                                            .map(employeeMapper::toApiDto)
                                            .orElseThrow(() -> new IllegalArgumentException("Cannot create employee"));
        return ResponseEntity.ok(newApiDto);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Long employeeId) {
        employeeService.delete(employeeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<EmployeeApiDto> getEmployee(Long employeeId) {
        EmployeeDto employee = employeeService.getEmployee(employeeId);
        EmployeeApiDto employeeApiDto = employeeMapper.toApiDto(employee);
        return ResponseEntity.ok(employeeApiDto);
    }

    @Override
    public ResponseEntity<List<EmployeeApiDto>> listEmployees() {
        List<EmployeeApiDto> employees = employeeService.getAll()
                                                        .stream()
                                                        .map(employeeMapper::toApiDto)
                                                        .toList();
        return ResponseEntity.ok(employees);
    }

    @Override
    public ResponseEntity<EmployeeApiDto> updateEmployee(Long employeeId, EmployeeApiDto employeeApiDto) {
        EmployeeDto businessDto = employeeMapper.toBusinessDto(employeeApiDto);
        businessDto.setId(employeeId);
        EmployeeDto updatedDto = employeeService.update(businessDto);
        EmployeeApiDto updatedEmployeeApiDto = employeeMapper.toApiDto(updatedDto);
        return ResponseEntity.ok(updatedEmployeeApiDto);
    }
}
