package training.microservices.employees.persistent.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import training.microservices.employees.persistent.mysql.entity.Employee;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Long> {

}