package com.cafeto.challenge.clinic.service;

import com.cafeto.challenge.clinic.model.Clinic;
import com.cafeto.challenge.clinic.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class ClinicServiceHandler implements ClinicService {

    @Autowired
    ClinicRepository repository;

    @Override
    public Clinic save(Clinic model) throws Exception {
        return repository.save(model);
    }

    @Override
    public Optional<Clinic> findById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseGet(Clinic::new));
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<Clinic> findAll() {
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
    public void delete(Clinic model) {
        repository.delete(model);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
