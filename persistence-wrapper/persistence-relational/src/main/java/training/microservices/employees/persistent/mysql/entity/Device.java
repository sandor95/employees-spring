package training.microservices.employees.persistent.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DEVICE")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employee employee;

    @NotNull(message = "Device name cannot be null")
    @Size(min = 1, max = 100, message = "Device name must be between 1 and 100 characters")
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Size(max = 255, message = "Details must be at most 256 characters")
    @Column(name = "DETAILS", length = 256)
    private String details;
}
