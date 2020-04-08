package com.challenge.nephrologistType.service;

import com.challenge.nephrologistType.model.NephrologistType;
import com.challenge.nephrologistType.repository.NephrologistTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class NephrologistTypeServiceHandler implements NephrologistTypeService {

    @Autowired
    NephrologistTypeRepository repository;

    @Override
    public NephrologistType save(NephrologistType model) throws Exception {
        return repository.save(model);
    }

    @Override
    public Optional<NephrologistType> findById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseGet(NephrologistType::new));
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<NephrologistType> findAll() {
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
    public void delete(NephrologistType model) {
        repository.delete(model);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
