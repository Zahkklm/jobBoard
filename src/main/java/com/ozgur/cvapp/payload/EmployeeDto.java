package com.ozgur.cvapp.payload;

import java.util.Set;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class EmployeeDto {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String firstname;

    private String surname;

    private String phoneNumber;

    private String jobExperience;

    private Integer experienceYears;

    private Integer demandedSalary;

    private String noticeTime;

    private Boolean militaryService;

}
