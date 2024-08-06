package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Config {
    private JsonNode config;

    public Config() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String projectDir = System.getProperty("user.dir");
            config = mapper.readTree(new File(projectDir + "/src/main/resources/config.json"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isHeadless() {
        return config.get("headless").asBoolean();
    }
}
