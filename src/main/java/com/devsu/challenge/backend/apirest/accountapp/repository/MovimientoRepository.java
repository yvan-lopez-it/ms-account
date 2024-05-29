package com.devsu.challenge.backend.apirest.accountapp.repository;

import com.devsu.challenge.backend.apirest.accountapp.entity.Movimiento;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    List<Movimiento> findByCuentaIdAndFechaBetween(Long cuentaId, LocalDate startDate, LocalDate endDate);

    //List<Movimiento> findByCuenta(String numeroCuenta);

    //List<Movimiento> findByFechaAnd(String fechaInicio, String fechaFin, String cliente);

}
