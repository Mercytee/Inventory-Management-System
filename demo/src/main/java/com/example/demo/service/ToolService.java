package com.example.demo.service;

import com.example.demo.model.Tool;
import com.example.demo.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ToolService {
    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> getToolsByCategory(String category) {
        return toolRepository.findByCategory(category);
    }

    public Tool addTool(Tool tool) {
        return toolRepository.save(tool);
    }

    public Tool updateTool(Long toolId, Tool updatedTool) {
        Tool existingTool = toolRepository.findById(toolId)
                .orElseThrow(() -> new RuntimeException("Tool not found with id: " + toolId));

        existingTool.setName(updatedTool.getName());
        existingTool.setDescription(updatedTool.getDescription());
        existingTool.setCategory(updatedTool.getCategory());

        return toolRepository.save(existingTool);
    }

    public void deleteTool(Long toolId) {
        Tool tool = toolRepository.findById(toolId)
                .orElseThrow(() -> new RuntimeException("Tool not found with id: " + toolId));

        toolRepository.delete(tool);
    }

    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }

    public Tool getToolById(Long toolId) {
        return toolRepository.findById(toolId)
                .orElseThrow(() -> new RuntimeException("Tool not found with id: " + toolId));
    }

    public List<Tool> searchToolsByName(String name) {
        return toolRepository.findByNameContaining(name);
    }

    public int countToolsByCategory(String category) {
        return toolRepository.countByCategory(category);
    }
}