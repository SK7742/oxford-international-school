package com.sansInfoTech.oxfordInternational.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class SqlDataLoader {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
    @PostConstruct
    public void executeSqlScript() {
    	String testDataLoad = "select count(*) from standard";
    	int count = jdbcTemplate.queryForObject(testDataLoad, Integer.class);
    	if(count == 0) {
	        try {
	            // Path to your SQL script file
	            String sqlFilePath = "src/main/resources/masterData.sql";
	
	            // Read the SQL script file content
	            List<String> sqlScript = readFile(sqlFilePath);
	
	            // Execute SQL script
	            for(String sql : sqlScript) {
	            	jdbcTemplate.execute(sql);
	            	System.out.println(sql);
	            }
	            
	        } catch (IOException e) {
	            System.err.println("Failed to read SQL script file: " + e.getMessage());
	        } catch (Exception e) {
	            System.err.println("Failed to execute SQL script: " + e.getMessage());
	        }
        }
    }
    
    private List<String> readFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().collect(Collectors.toList());
        }
    }
}
