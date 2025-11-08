package com.maven.album;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Service
public class ProducerService {

    private final List<Producer> producers = new ArrayList<>();

    public List<Producer> getAllProducers() {
        return producers;
    }

    public void addProducer(String name, String email) {
        long newId = producers.size() + 1L;
        producers.add(new Producer(newId, name, email));
    }

    public Optional<Producer> getProducerById(Long id) {
        return producers.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public void addProjectToProducer(Long producerId, String title, LocalDate startDate) {
        getProducerById(producerId).ifPresent(p -> {
            long newId = p.getProjects().size() + 1L;
            p.addProject(new Project(newId, title, startDate));
        });
    }

    public void generateMagicLink(Long producerId, Long projectId) {
        getProducerById(producerId).ifPresent(p -> {
            p.getProjects().stream()
                .filter(proj -> proj.getId().equals(projectId))
                .findFirst()
                .ifPresent(proj -> {
                    String token = UUID.randomUUID().toString();
                    proj.setMagicLink("http://localhost:8080/worksheet/" + projectId + "/" + token);
                });
        });
    }

    public String sendMagicLink(Long producerId, Long projectId) {
        return getProducerById(producerId)
            .flatMap(p -> p.getProjects().stream()
                .filter(proj -> proj.getId().equals(projectId))
                .findFirst()
                .map(proj -> "Sent to " + p.getEmail() + ": " + proj.getMagicLink()))
            .orElse("Producer/Project not found");
    }
}
