package com.example.demoApplication;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitsRepository extends JpaRepository<Visit, Long> {
    List<Visit> findByName(String name, Pageable pageRequest);
}
