package com.cafeto.challenge.nephrologist.repository;

import com.cafeto.challenge.nephrologist.model.Nephrologist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NephrologistRepository extends JpaRepository<Nephrologist, Long> {
}
