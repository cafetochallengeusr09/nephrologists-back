package com.cafeto.challenge.clinic.repository;

import com.cafeto.challenge.clinic.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
