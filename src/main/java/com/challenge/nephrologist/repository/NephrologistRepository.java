package com.challenge.nephrologist.repository;

import com.challenge.nephrologist.model.Nephrologist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NephrologistRepository extends JpaRepository<Nephrologist, Long> {
}
