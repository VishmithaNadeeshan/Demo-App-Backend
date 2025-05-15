package edu.icet.dto;
import edu.icet.util.DepartmentType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;

    @Valid

    @NotBlank(message = "name is mandatory")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces")
    private String name;

    @NotBlank(message = "email is mandatory")
    @Pattern(regexp = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$", message = "not a valid email address")
    private String email;

    @NotNull(message = "department cannot be null")
    private DepartmentType department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
