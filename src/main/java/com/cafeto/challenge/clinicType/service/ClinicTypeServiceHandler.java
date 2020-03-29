package com.cafeto.challenge.clinicType.service;

import com.cafeto.challenge.clinicType.model.ClinicType;
import com.cafeto.challenge.clinicType.repository.ClinicTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class ClinicTypeServiceHandler implements ClinicTypeService {

    @Autowired
    ClinicTypeRepository repository;

    @Override
    public ClinicType save(ClinicType model) throws Exception {
        return repository.save(model);
    }

    @Override
    public Optional<ClinicType> findById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseGet(ClinicType::new));
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<ClinicType> findAll() {
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
    public void delete(ClinicType model) {
        repository.delete(model);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
