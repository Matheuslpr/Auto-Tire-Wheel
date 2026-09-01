package dev.matheus.infrastructure.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RodasRepository extends JpaRepository<RodasEntity, Long> {

    Optional<RodasEntity> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);

}
