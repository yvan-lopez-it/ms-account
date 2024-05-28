package com.devsu.challenge.backend.apirest.accountapp.repository;

import com.devsu.challenge.backend.apirest.accountapp.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

}
