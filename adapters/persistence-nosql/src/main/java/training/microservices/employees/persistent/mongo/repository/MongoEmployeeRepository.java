package training.microservices.employees.persistent.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import training.microservices.employees.persistent.mongo.entity.Employee;

@Repository
public interface MongoEmployeeRepository extends MongoRepository<Employee, String> {

}
