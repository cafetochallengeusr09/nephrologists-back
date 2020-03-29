package com.cafeto.challenge.nephrologist.service;

import com.cafeto.challenge.nephrologist.model.Nephrologist;
import com.cafeto.challenge.nephrologist.repository.NephrologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class NephrologistServiceHandler implements NephrologistService {

    @Autowired
    NephrologistRepository repository;

    @Override
    public Nephrologist save(Nephrologist model) throws Exception {
        return repository.save(model);
    }

    @Override
    public Optional<Nephrologist> findById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseGet(Nephrologist::new));
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<Nephrologist> findAll() {
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
    public void delete(Nephrologist model) {
        repository.delete(model);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
