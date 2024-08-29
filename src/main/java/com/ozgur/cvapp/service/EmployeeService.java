package com.ozgur.cvapp.service;

import com.ozgur.cvapp.model.User;
import com.ozgur.cvapp.payload.request.SignupRequest;
import com.ozgur.cvapp.repository.EmployeeRepository;
import com.ozgur.cvapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;

    public User changeUserDetails(SignupRequest signUpRequest, UserDetailsImpl userDetails) {
        User user = User.builder()
                .firstname(signUpRequest.getFirstname())
                .surname(signUpRequest.getSurname())
                .phoneNumber(signUpRequest.getPhoneNumber())
                .jobExperience(signUpRequest.getJobExperience())
                .experienceYears(signUpRequest.getExperienceYears())
                .demandedSalary(signUpRequest.getDemandedSalary())
                .noticeTime(signUpRequest.getNoticeTime())
                .militaryService(signUpRequest.getMilitaryService())
                .build();

        userRepository.save(user);

        log.info("Changed from: {} to: {}", userDetails, user);
        return user;
    }
}
