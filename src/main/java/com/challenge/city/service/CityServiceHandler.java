package com.challenge.city.service;

import com.challenge.city.model.City;
import com.challenge.city.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class CityServiceHandler implements CityService {

    @Autowired
    CityRepository repository;

    @Override
    public City save(City model) throws Exception {
        return repository.save(model);
    }

    @Override
    public Optional<City> findById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseGet(City::new));
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<City> findAll() {
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
    public void delete(City model) {
        repository.delete(model);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
