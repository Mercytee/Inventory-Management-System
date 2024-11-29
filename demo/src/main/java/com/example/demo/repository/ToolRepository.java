package com.example.demo.repository;

import com.example.demo.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
    List<Tool> findByName(String name);
    List<Tool> findByCategoryAndName(String category, String name);
    List<Tool> findByCategoryAndDescriptionContaining(String category, String keyword);
    List<Tool> findByCategory(String category);
    List<Tool> findByNameContaining(String name);
    int countByCategory(String category);
}