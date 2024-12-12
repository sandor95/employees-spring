package training.microservices.employees.persistent.mongo;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import training.microservices.employees.persistent.mongo.entity.Device;
import training.microservices.employees.persistent.mongo.entity.Employee;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "createEmployeeCollection", author = "employeeManager")
    public void createEmployeeCollection(MongoTemplate mongoTemplate) {
        if (!mongoTemplate.collectionExists(Employee.class)) {
            mongoTemplate.createCollection(Employee.class);
        }
    }

    @ChangeSet(order = "002", id = "createDeviceCollection", author = "employeeManager")
    public void createDeviceCollection(MongoTemplate mongoTemplate) {
        if (!mongoTemplate.collectionExists(Device.class)) {
            mongoTemplate.createCollection(Device.class);
        }
    }
}
