package com.lbarberis.demorest.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SerializeService {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final ObjectMapper MAPPER = new ObjectMapper().setDateFormat(DATE_FORMAT).registerModule(new JavaTimeModule());
    private static final Path JSON_PATH = Paths.get("src", "main", "resources", "data");

    public static <T> List<T> getListFromJson(Class classType, String file) {

        List<T> list = new ArrayList<>();
        try {
            list = MAPPER.readValue(JSON_PATH.resolve(file).toFile(), MAPPER.getTypeFactory().constructCollectionType(List.class, classType));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

}
