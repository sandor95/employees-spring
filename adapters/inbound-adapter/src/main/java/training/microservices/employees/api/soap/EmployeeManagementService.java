package training.microservices.employees.api.soap;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.training.microservices.emptrack.employees.*;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.microservices.employees.api.soap.mapper.EmployeeSoapMapper;
import training.microservices.employees.dto.EmployeeDto;
import training.microservices.employees.service.EmployeeService;

@WebService(targetNamespace = "http://emptrack.microservices.training.com/employees", name = "EmployeeManagementPortType",
            serviceName = "EmployeeManagementService", endpointInterface = "com.training.microservices.emptrack.employees.EmployeeManagementPortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@Service
public class EmployeeManagementService implements EmployeeManagementPortType {

    private EmployeeSoapMapper employeeMapper;

    private EmployeeService employeeService;

    @Autowired
    public EmployeeManagementService(EmployeeSoapMapper employeeMapper, EmployeeService employeeService) {
        this.employeeMapper = employeeMapper;
        this.employeeService = employeeService;
    }

    @Override
    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest request) {
        Objects.requireNonNull(request, "No request body!");
        EmployeeDto employeeDto = Optional.of(request)
                                                .map(UpdateEmployeeRequest::getEmployee)
                                                .map(employeeMapper::toBusinessDto)
                                                .orElseThrow(() -> new IllegalArgumentException("Cannot update employee without given employee!"));
        employeeDto.setId(request.getEmployeeId());
        EmployeeApiDto updatedEmployee = Optional.of(employeeDto)
                                                 .map(employeeService::update)
                                                 .map(employeeMapper::toApiDto)
                                                 .get();
        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.setEmployee(updatedEmployee);
        return response;
    }

    @Override
    public GetEmployeeResponse getEmployee(GetEmployeeRequest parameters) {
        EmployeeApiDto foundEmployee = Optional.of(parameters.getEmployeeId())
                                               .map(employeeService::getEmployee)
                                               .map(employeeMapper::toApiDto)
                                               .orElse(null);
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setEmployee(foundEmployee);
        return response;
    }

    @Override
    public DeleteEmployeeResponse deleteEmployee(DeleteEmployeeRequest parameters) {
        Optional.of(parameters.getEmployeeId())
                .map(employeeService::delete)
                .map(employeeMapper::toApiDto)
                .orElseThrow(() -> new RuntimeException("Cannot delete employee by id: " + parameters.getEmployeeId()));
        return new DeleteEmployeeResponse();
    }

    @Override
    public ListEmployeesResponse listEmployees() {
        ListEmployeesResponse response = new ListEmployeesResponse();
        List<EmployeeApiDto> employees = employeeService.getAll().stream().map(employeeMapper::toApiDto).toList();
        response.getEmployees().addAll(employees);
        return response;
    }

    @Override
    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest parameters) {
        EmployeeApiDto newEmployee = Optional.of(parameters)
                                             .map(CreateEmployeeRequest::getEmployee)
                                             .map(employeeMapper::toBusinessDto)
                                             .map(employeeService::create)
                                             .map(employeeMapper::toApiDto)
                                             .orElseThrow(() -> new RuntimeException("Cannot create new Employee"));
        CreateEmployeeResponse response = new CreateEmployeeResponse();
        response.setEmployee(newEmployee);
        return response;
    }
}
