package ru.itpark.service;

import org.springframework.stereotype.Service;
import ru.itpark.domain.Brevet;
import ru.itpark.repository.BrevetRepository;

import java.util.List;

@Service
public class BrevetService {
    private final BrevetRepository brevetRepository;

    public BrevetService(BrevetRepository brevetRepository) {
        this.brevetRepository = brevetRepository;
    }

    public  List<Brevet> findAll() {
        return BrevetRepository.findAll();
    }
}
