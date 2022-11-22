package com.user.registration.dao;

import com.user.registration.model.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContactRepo extends JpaRepository<UserContact, Long> {
}
