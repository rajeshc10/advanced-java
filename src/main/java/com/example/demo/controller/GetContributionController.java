package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GetContributionController {
    private Map<String, Integer> departmentEmployeeCountMap;

    public GetContributionController() {
        // Initialize the map with sample department names and their counts
        departmentEmployeeCountMap = new HashMap<>();
        departmentEmployeeCountMap.put("HR", 50);
        departmentEmployeeCountMap.put("Finance", 40);
        departmentEmployeeCountMap.put("IT", 60);
        // Add more departments as needed
    }

    @GetMapping("/myhr/employee/getContribution/{departmentName}")
    public ResponseEntity<?> getContribution(@PathVariable String departmentName) {
        // Retrieve the latest count for the given department
        Integer latestCount = departmentEmployeeCountMap.get(departmentName);
        if (latestCount != null) {
            // Return the latest count as part of the response body
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("departmentName", departmentName);
            responseBody.put("latestCount", latestCount);
            return ResponseEntity.ok(responseBody);
        } else {
            // Return a response indicating that the department was not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Department not found: " + departmentName);
        }
    }
}



