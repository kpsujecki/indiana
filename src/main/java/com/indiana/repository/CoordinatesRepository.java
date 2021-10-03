package com.indiana.repository;

import com.indiana.models.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatesRepository extends JpaRepository<Coordinates, Long> {
}
