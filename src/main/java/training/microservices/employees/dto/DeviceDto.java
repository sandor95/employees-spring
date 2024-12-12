package training.microservices.employees.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Valid
public class DeviceDto {

    private Long id;

    @NotNull(message = "employeeId cannot be null")
    private Long employeeId;

    @NotBlank(message = "name cannot be empty")
    @Max(message = "name is too long", value = 500)
    private String name;

    @Max(message = "details is too long", value = 2_000)
    private String details;
}
