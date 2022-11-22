package com.user.registration.dao;

import com.user.registration.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails, Long> {

   // @Query(value = "select * from user_details u where u.email
  // List<UserDetails> findByNameContainingOrAgeContainingOrSalaryContaining (String name, Long age, Long salary );
   // List<UserDetails> findByNameOrAgeOrSalary(String name, Long age, Long salary );

   Boolean existsByEmail(String email);

    @Query(value = "select email from user_details u where u.email =:email", nativeQuery = true)
   String findByEmail(@Param("email") String email);

    List<UserDetails> findBySalary(Long salary);

    List<UserDetails> findByAge(Long age);

    @Query(value = "select * from user_details u where u.email =:email", nativeQuery = true)
    List<UserDetails> searchByEmail(String email);

}
