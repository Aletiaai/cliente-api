package com.github.aletiaai.cliente_api.repository;

import com.github.aletiaai.cliente_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que esta interfaz es un repositorio de Spring Data JPA
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Esta interfaz extiende JpaRepository, que proporciona métodos CRUD (Crear, Leer, Actualizar, Borrar) para la entidad Cliente.
    // Cliente es el tipo de entidad manejada por este repositorio.
    // Long es el tipo de la clave primaria de la entidad Cliente.

    // No se necesitan métodos adicionales aquí, ya que JpaRepository proporciona los métodos básicos.
    // Si se necesitan métodos de consulta personalizados, se pueden definir aquí.

}
