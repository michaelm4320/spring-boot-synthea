package com.example.spring_boot_synthea;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/myendpoint/api")
@CrossOrigin(origins = "http://localhost:5173")
public class PatientController {

    @PostMapping("/generate-patient")
    public ResponseEntity<Map<String, String>> generatePatient() {
        String result = "";
        try {
            // Full path to the run_synthea executable
            String syntheaExecutablePath = "C:/Users/Michael/Documents/Java Projects/Spring Boot Synthea/spring-boot-synthea/synthea-master/run_synthea.bat";

            ProcessBuilder processBuilder = new ProcessBuilder(syntheaExecutablePath, "-p", "1", "Florida");
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            result = output.toString();
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        // Wrap the result in a JSON object
        Map<String, String> response = new HashMap<>();
        response.put("output", result);
        return ResponseEntity.ok(response);
    }

    // Handle OPTIONS request explicitly for /generate-patient endpoint
    @RequestMapping(value = "/generate-patient", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .build();
    }
}
