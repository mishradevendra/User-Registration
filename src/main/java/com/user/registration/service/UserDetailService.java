package com.user.registration.service;

import com.user.registration.model.UserDetails;
import com.user.registration.model.UserLogin;

import java.util.List;

public interface UserDetailService {

   //save userDetails
    public void saveUserDetails(UserDetails userDetails);

    // login user
    public void loginUser(UserLogin userLogin);


}
