package com.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartmediator.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}