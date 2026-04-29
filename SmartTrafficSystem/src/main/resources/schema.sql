CREATE TABLE IF NOT EXISTS violations (
                                          id SERIAL PRIMARY KEY,
                                          vehicle_id VARCHAR(50),
    speed DOUBLE PRECISION,
    zone VARCHAR(50),
    fine INT
    );