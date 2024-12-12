package training.microservices.employees.dto;

import java.time.LocalDate;
import java.util.Collection;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;

    @NotBlank
    private String surname;

    @NotBlank
    private String lastname;

    private String lastname2;

    @NotNull
    private LocalDate dateOfBirth;

    private Collection<@Valid DeviceDto> devices;
}
