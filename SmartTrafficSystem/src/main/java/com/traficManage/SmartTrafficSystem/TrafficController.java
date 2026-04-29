package com.traficManage.SmartTrafficSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/traffic")
public class TrafficController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Your original fine calculator logic
    private int calculateFine(double speed) {
        if (speed > 120) return 5000;
        else if (speed > 100) return 2000;
        else return 1000;
    }

    // This creates a web endpoint at http://localhost:8080/api/traffic/check
    @PostMapping("/check")
    public ResponseEntity<?> checkEvent(@RequestBody VehicleEvent event) {

        // Your original violation filter logic
        if (event.getSpeed() > 80 && !event.isEmergencyVehicle()) {

            int fine = calculateFine(event.getSpeed());

            // SQL to insert the record into your Neon database
            String sql = "INSERT INTO violations (vehicle_id, speed, zone, fine) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, event.getVehicleId(), event.getSpeed(), event.getZone(), fine);

            return ResponseEntity.ok(Map.of(
                    "status", "VIOLATION_DETECTED",
                    "message", "Fine saved to database!",
                    "vehicleId", event.getVehicleId(),
                    "fine", "₹" + fine
            ));
        }

        return ResponseEntity.ok(Map.of(
                "status", "SAFE",
                "message", "No violation detected. Good driving!"
        ));
    }
}