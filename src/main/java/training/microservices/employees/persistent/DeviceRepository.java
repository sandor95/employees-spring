package training.microservices.employees.persistent;

import training.microservices.employees.dto.DeviceDto;

public interface DeviceRepository {

    DeviceDto addDeviceToEmployee(DeviceDto deviceDto);

    boolean removeDeviceFromEmployee(Long deviceId, Long employeeId);

}
