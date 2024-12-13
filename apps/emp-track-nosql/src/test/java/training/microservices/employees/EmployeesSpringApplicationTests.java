package training.microservices.employees;

import java.time.LocalDate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import training.microservices.employees.persistent.mongo.entity.Employee;
import training.microservices.employees.persistent.mongo.repository.MongoEmployeeRepository;

@Slf4j
@SpringBootTest
class EmployeesSpringApplicationTests {

	@Autowired
	MongoEmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
		Employee employee = new Employee("124", "Doe", "John", "Jack", LocalDate.of(1990, 2, 4), null);
		Employee saved = employeeRepository.save(employee);
		log.info("Employee saved: {}", saved);
	}

}
