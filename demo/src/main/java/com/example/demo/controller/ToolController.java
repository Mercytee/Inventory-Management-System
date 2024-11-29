package com.example.demo.controller;

import com.example.demo.model.Tool;
import com.example.demo.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolController {

    @Autowired
    private ToolService toolService;

    @GetMapping("/{id}")
    public Tool getToolById(@PathVariable Long id) {
        return toolService.getToolById(id);
    }

    @GetMapping("/category/{category}")
    public List<Tool> getToolsByCategory(@PathVariable String category) {
        return toolService.getToolsByCategory(category);
    }

    @PostMapping
    public Tool addTool(@RequestBody Tool tool) {
        return toolService.addTool(tool);
    }

    @PutMapping("/{id}")
    public Tool updateTool(@PathVariable Long id, @RequestBody Tool updatedTool) {
        return toolService.updateTool(id, updatedTool);
    }

    @DeleteMapping("/{id}")
    public void deleteTool(@PathVariable Long id) {
        toolService.deleteTool(id);
    }

    @GetMapping
    public List<Tool> getAllTools() {
        return toolService.getAllTools();
    }

    @GetMapping("/search")
    public List<Tool> searchToolsByName(@RequestParam String name) {
        return toolService.searchToolsByName(name);
    }

    @GetMapping("/count/{category}")
    public int countToolsByCategory(@PathVariable String category) {
        return toolService.countToolsByCategory(category);
    }
}
