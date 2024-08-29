package com.ozgur.boardapp.service;
import com.ozgur.boardapp.payload.request.SignupRequest;
import com.ozgur.boardapp.repository.EmployeeRepository;
import com.ozgur.boardapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    PasswordEncoder encoder;

    public List<User> getAllUsers() {
        return employeeRepository.findAll().stream()
                .map(user -> user.builder()
                        .email(user.getEmail())
                        .username(user.getUsername())
                        .password(encoder.encode(user.getPassword()))
                        .firstname(user.getFirstname())
                        .surname(user.getSurname())
                        .phoneNumber(user.getPhoneNumber())
                        .jobExperience(user.getJobExperience())
                        .experienceYears(user.getExperienceYears())
                        .demandedSalary(user.getDemandedSalary())
                        .noticeTime(user.getNoticeTime())
                        .militaryService(user.getMilitaryService())
                        .build())
                .collect(Collectors.toList());
    }

    public User getUserById(Long id) {
        User user = employeeRepository.findById(id).orElseThrow();
        return  User.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .password(encoder.encode(user.getPassword()))
                .firstname(user.getFirstname())
                .surname(user.getSurname())
                .phoneNumber(user.getPhoneNumber())
                .jobExperience(user.getJobExperience())
                .experienceYears(user.getExperienceYears())
                .demandedSalary(user.getDemandedSalary())
                .noticeTime(user.getNoticeTime())
                .militaryService(user.getMilitaryService())
                .build();
    }

    public void addUser(SignupRequest signUpRequest) {
        User user = User.builder()
                .email(signUpRequest.getEmail())
                .username(signUpRequest.getUsername())
                .password(encoder.encode(signUpRequest.getPassword()))
                .firstname(signUpRequest.getFirstname())
                .surname(signUpRequest.getSurname())
                .phoneNumber(signUpRequest.getPhoneNumber())
                .jobExperience(signUpRequest.getJobExperience())
                .experienceYears(signUpRequest.getExperienceYears())
                .demandedSalary(signUpRequest.getDemandedSalary())
                .noticeTime(signUpRequest.getNoticeTime())
                .militaryService(signUpRequest.getMilitaryService())
                .build();


        employeeRepository.save(user);
    }
}
