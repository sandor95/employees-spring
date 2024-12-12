package training.microservices.employees.persistent.mysql.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Surname cannot be null")
    @Size(min = 1, max = 50, message = "Surname must be between 1 and 80 characters")
    @Column(name = "SURNAME", nullable = false, length = 80)
    private String surname;

    @NotNull(message = "Lastname cannot be null")
    @Size(min = 1, max = 50, message = "Lastname must be between 1 and 50 characters")
    @Column(name = "LASTNAME", nullable = false, length = 50)
    private String lastname;

    @Size(max = 50, message = "Lastname2 must be at most 50 characters")
    @Column(name = "LASTNAME2", length = 50)
    private String lastname2;

    @NotNull(message = "Date of birth cannot be null")
    @Past(message = "Date of birth must be a past date")
    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Device> devices;
}
