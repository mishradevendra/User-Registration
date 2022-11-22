package com.user.registration.controller;

import com.user.registration.dao.UserDetailsRepo;
import com.user.registration.dao.UserLoginRepo;
import com.user.registration.exception.ResourceNotFoundException;
import com.user.registration.model.UserDetails;
import com.user.registration.model.UserLogin;
import com.user.registration.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserDetailsController {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @Autowired
    private UserLoginRepo userLoginRepo;

    // Save operation
    @PostMapping("/save")
    public ResponseEntity<Object> saveUserDetails(@Valid @RequestBody UserDetails userDetails){

        if(userDetailsRepo.existsByEmail(userDetails.getEmail())){
            return new ResponseEntity<>("Email is already exists!", HttpStatus.BAD_REQUEST);
        }
        userDetailService.saveUserDetails(userDetails);
        return new ResponseEntity<>("User Details Saved!", HttpStatus.OK);
    }

    //user login

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@Valid @RequestBody UserLogin userLogin){

        String userName = userDetailsRepo.findByEmail(userLogin.getUserName());
        String password = userLoginRepo.findByPassword(userLogin.getPassword());

        if(userLogin.getUserName().equalsIgnoreCase(userName) &&  userLogin.getPassword().equalsIgnoreCase(password)){

            userDetailService.loginUser(userLogin);
            return new ResponseEntity<>("User Loged In Successful", HttpStatus.OK);
        }
            return new ResponseEntity<>("User Does not exist!", HttpStatus.BAD_REQUEST);
    }

    //Read operation
   /* @GetMapping("/search")
    public ResponseEntity<List<UserDetails>> fetchUsersDetailsBySearchKeys(@RequestParam(required = false)  String name, @RequestParam(required = false)  Long age, @RequestParam(required = false)  Long salary )
    {
        return new ResponseEntity<List<UserDetails>>(userDetailsRepo.findByNameContainingOrAgeContainingOrSalaryContaining(name, age, salary), HttpStatus.OK);
    }*/

    //Search By Email
    @GetMapping("/searchByEmail/{email}")
    public ResponseEntity<List<UserDetails>> searchUsersByEmail(@PathVariable("email") String email){
        List<UserDetails> userDetails = new ArrayList<>();
        userDetailsRepo.searchByEmail(email).forEach(userDetails::add);

        if(userDetails.isEmpty()) {
            throw new ResourceNotFoundException("Email Id Not Found! = " +email);
        }
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }

    //Search By Age
    @GetMapping("/searchByAge/{age}")
    public ResponseEntity<List<UserDetails>> searchUserByAge (@PathVariable("age") Long age) {
        List<UserDetails> userDetails = new ArrayList<>();
       userDetailsRepo.findByAge(age).forEach(userDetails::add);
        if(userDetails.isEmpty()) {
            throw new ResourceNotFoundException("User Not Found with age = " +age);
        }
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }

    //Search By Salary
    @GetMapping("/searchBySalary/{salary}")
    public ResponseEntity<List<UserDetails>> searchUserBySalary (@PathVariable("salary") Long salary) {
        List<UserDetails> userDetails = new ArrayList<>();
        userDetailsRepo.findBySalary(salary)
                .forEach(userDetails::add);
        if(userDetails.isEmpty()) {
            throw new ResourceNotFoundException("User Not Found with salary = " +salary);
        }
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }
}
