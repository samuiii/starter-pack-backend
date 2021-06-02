package com.example.demo.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("SELECT s FROM Project s WHERE s.name = ?1")
    Optional<Project> findProjectByName(String name);

    @Query("SELECT s FROM Project s ORDER BY s.rating")
    List<Project> findByorderASCRate();
    @Query("SELECT s FROM Project s ORDER BY s.rating DESC ")
    List<Project> findByorderDescRate();

    @Query("SELECT s FROM Project s ORDER BY s.date")
    List<Project> findByorderASCdate();
    @Query("SELECT s FROM Project s ORDER BY s.date DESC ")
    List<Project> findByorderDescdate();
}
