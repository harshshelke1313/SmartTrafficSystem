package com.traficManage.SmartTrafficSystem;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ViolationRepository {
    private final JdbcTemplate jdbcTemplate;

    public ViolationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveViolation(ViolationRecord record) {
        String sql = "INSERT INTO violations (vehicle_id, speed, zone, fine) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, record.vehicleId, record.speed, record.zone, record.fine);
    }
}