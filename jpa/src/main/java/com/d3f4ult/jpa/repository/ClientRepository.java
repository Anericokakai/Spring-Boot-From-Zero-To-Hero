package com.d3f4ult.jpa.repository;

import com.d3f4ult.jpa.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
