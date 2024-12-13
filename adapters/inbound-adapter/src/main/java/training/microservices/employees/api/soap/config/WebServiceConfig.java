package training.microservices.employees.api.soap.config;

import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import training.microservices.employees.api.soap.EmployeeManagementService;
import training.microservices.employees.api.soap.mapper.EmployeeSoapMapper;
import training.microservices.employees.service.EmployeeService;

@Configuration
public class WebServiceConfig {

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public EmployeeManagementService employeeManagementService(EmployeeSoapMapper employeeSoapMapper, EmployeeService employeeService) {
        return new EmployeeManagementService(employeeSoapMapper, employeeService);
    }

    @Bean
    public Endpoint employeeManagementEndpoint(EmployeeManagementService employeeManagementService) {
        EndpointImpl endpoint = new EndpointImpl(new SpringBus(), employeeManagementService);
        endpoint.publish("/services/employees");
        return endpoint;
    }
}
