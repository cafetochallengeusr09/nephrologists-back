package com.cafeto.challenge.zone.service;

import com.cafeto.challenge.zone.model.Zone;
import com.cafeto.challenge.zone.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class ZoneServiceHandler implements ZoneService {

    @Autowired
    ZoneRepository repository;

    @Override
    public Zone save(Zone model) throws Exception {
        return repository.save(model);
    }

    @Override
    public Optional<Zone> findById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseGet(Zone::new));
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<Zone> findAll() {
        return repository.findAll();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Zone model) {
        repository.delete(model);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
