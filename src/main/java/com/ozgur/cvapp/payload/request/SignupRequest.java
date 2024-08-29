package com.ozgur.cvapp.payload.request;

import java.util.Set;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    private String password;

    private Long KVKK;

    private String CVLink;

    private String firstname;

    private String surname;

    private String phoneNumber;

    private String jobExperience;

    private Integer experienceYears;

    private Integer demandedSalary;

    private String noticeTime;

    private Boolean militaryService;

}
