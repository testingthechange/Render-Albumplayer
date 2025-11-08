package com.maven.album;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class IncomingService {
    private static final String INCOMING_DIR = "src/main/resources/incoming";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<IncomingRecord> loadIncoming() {
        List<IncomingRecord> results = new ArrayList<>();
        File folder = new File(INCOMING_DIR);

        if (folder.exists() && folder.isDirectory()) {
            for (File file : Objects.requireNonNull(folder.listFiles())) {
                if (file.getName().endsWith(".json")) {
                    try {
                        Map<String, Object> data = mapper.readValue(file, Map.class);

                        IncomingRecord record = new IncomingRecord();
                        record.setProjectId(Long.valueOf(data.getOrDefault("projectId", "0").toString()));
                        record.setProducerName(data.getOrDefault("producerName", "Unknown Producer").toString());
                        record.setProjectStartDate(data.getOrDefault("projectStartDate", "N/A").toString());
                        record.setDateReceived(LocalDateTime.now());

                        record.setAlbum8("album8.json");
                        record.setShuffle8("shuffle8.json");
                        record.setAlbum9("album9.json");
                        record.setShuffle9("shuffle9.json");
                        record.setMeta("meta.json");

                        for (int i = 0; i < 9; i++) {
                            record.getSongPages()[i] = "song" + (i+1) + ".json";
                        }

                        results.add(record);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return results;
    }
}
