package com.user.registration.dao;

import com.user.registration.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserLoginRepo extends JpaRepository<UserLogin, Long> {

   @Query(value = "select password from user_login u where u.password =:password", nativeQuery = true)
   String findByPassword(@Param("password") String password);
}
