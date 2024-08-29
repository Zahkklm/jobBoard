package com.ozgur.boardapp.controller;

import com.ozgur.boardapp.model.Test;
import com.ozgur.boardapp.model.User;
import com.ozgur.boardapp.payload.EmployeeDto;
import com.ozgur.boardapp.payload.TestDto;
import com.ozgur.boardapp.payload.request.SignupRequest;
import com.ozgur.boardapp.repository.TestRepository;
import com.ozgur.boardapp.service.AdminService;
import com.ozgur.boardapp.service.EmployeeService;
import com.ozgur.boardapp.service.UserDetailsImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TestRepository testRepository;

    @PreAuthorize("hasAuthority('ROLE_USER') or hasRole('ADMIN')")
    @GetMapping("/")
    public UserDetailsImpl getYourself(@AuthenticationPrincipal UserDetailsImpl user) {
        return user;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/changeInfo")
    public User addCustomer(@RequestBody SignupRequest signupRequest, @AuthenticationPrincipal UserDetailsImpl user) {
        return employeeService.changeUserDetails(signupRequest, user);
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Test>> getSomething() {
  //      return employeeService.changeUserDetails(signupRequest, user);
        try {
            List<Test> tests = new ArrayList<Test>();

                testRepository.findAll().forEach(tests::add);

            if (tests.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
