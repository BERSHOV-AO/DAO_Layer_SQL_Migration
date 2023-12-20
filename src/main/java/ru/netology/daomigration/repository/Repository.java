package ru.netology.daomigration.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SCRIPT_FILE_NAME = "return_product_name.sql";

    private String scriptContent;

    public Repository() {
        this.scriptContent = read(SCRIPT_FILE_NAME);
    }

    public List<String> getProductName(String name) {

        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return Collections.singletonList(this.namedParameterJdbcTemplate.queryForList(scriptContent,
                params, String.class).toString());
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


