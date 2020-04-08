package com.challenge.nephrologistBaseClinic.service;

import com.challenge.nephrologistBaseClinic.model.NephrologistBaseClinic;
import com.challenge.nephrologistBaseClinic.repository.NephrologistBaseClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class NephrologistBaseClinicServiceHandler implements NephrologistBaseClinicService {

    @Autowired
    NephrologistBaseClinicRepository repository;

    @Override
    public NephrologistBaseClinic save(NephrologistBaseClinic model) throws Exception {
        return repository.save(model);
    }

    @Override
    public Optional<NephrologistBaseClinic> findById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseGet(NephrologistBaseClinic::new));
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<NephrologistBaseClinic> findAll() {
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
    public void delete(NephrologistBaseClinic model) {
        repository.delete(model);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
