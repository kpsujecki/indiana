package com.indiana.repository;

import com.indiana.models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository <UserDetails, Long> {
}
