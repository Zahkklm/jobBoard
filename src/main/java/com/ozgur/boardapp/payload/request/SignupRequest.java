package com.ozgur.boardapp.payload.request;

import java.util.HashSet;
import java.util.Set;

import com.ozgur.boardapp.model.Role;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    private String firstname;

    private String surname;

    private String phoneNumber;

    private String jobExperience;

    private Integer experienceYears;

    private Integer demandedSalary;

    private String noticeTime;

    private Boolean militaryService;

}
