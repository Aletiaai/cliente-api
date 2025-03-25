package com.github.aletiaai.cliente_api.repository;

import com.github.aletiaai.cliente_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
