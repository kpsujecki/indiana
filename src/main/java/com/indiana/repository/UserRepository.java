package com.indiana.repository;

import java.util.Optional;

import com.indiana.models.Item;
import com.indiana.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  Page<User> findAllByUsernameContains(String username, Pageable pageable);
}
