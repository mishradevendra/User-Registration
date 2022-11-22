package com.user.registration.service;

import com.user.registration.dao.UserDetailsRepo;
import com.user.registration.dao.UserLoginRepo;
import com.user.registration.model.UserDetails;
import com.user.registration.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @Autowired
    private UserLoginRepo userLoginRepo;

    @Override
    public void saveUserDetails(UserDetails userDetails) {

        userDetailsRepo.save(userDetails);
    }

    @Override
    public void loginUser(UserLogin userLogin) {
        userLoginRepo.save(userLogin);
    }
}

   /* @Override
    public List<UserDetails> fetchUsersList() {
        return (List<UserDetails>) userDetailsRepo.findAll();
    }

}*/
