package com.project.project.repository;

import com.project.project.model.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FunctionRepository extends JpaRepository<Result, Long> {
    List<Result> findByDev(String Dev);

    Page<Result> findByDevContainingOrNameOrInsideContaining(String dev, String name, String inside, Pageable pageable);

}
