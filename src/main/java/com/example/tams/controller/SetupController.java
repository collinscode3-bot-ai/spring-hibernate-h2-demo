package com.example.tams.controller;

import com.example.tams.service.MockDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/setup")
@RequiredArgsConstructor
public class SetupController {

    private final MockDataService mockDataService;

    @GetMapping("/mock-data")
    public String generateMockData() {
        mockDataService.generateMockData();
        return "Mock data generated successfully!";
    }
}
