package ru.itpark.finalproject.service;

import org.springframework.stereotype.Service;
import ru.itpark.finalproject.domain.Brevet;
import ru.itpark.finalproject.repository.BrevetRepository;

import java.util.List;

@Service
public class BrevetService {
    private final BrevetRepository brevetRepository;

    public  BrevetService(BrevetRepository brevetRepository) {
        this.brevetRepository = brevetRepository;
    }


    public List<Brevet> findAll() {
        return brevetRepository.findAll();
    }
}
