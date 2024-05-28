package com.devsu.challenge.backend.apirest.accountapp.service.impl;

import com.devsu.challenge.backend.apirest.accountapp.entity.Movimiento;
import com.devsu.challenge.backend.apirest.accountapp.repository.MovimientoRepository;
import com.devsu.challenge.backend.apirest.accountapp.service.IMovimientoService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class MovimientoServiceImpl implements IMovimientoService {

    private final MovimientoRepository movimientoRepository;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }

    @Override
    public Optional<Movimiento> getMovimientoById(Long id) {
        return movimientoRepository.findById(id);
    }

    @Override
    public Movimiento createMovimiento(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public Movimiento updateMovimiento(Long id, Movimiento detalleMovimiento) {
        return movimientoRepository.findById(id)
            .map(movimiento -> {
                movimiento.setFecha(detalleMovimiento.getFecha());
                movimiento.setTipoMovimiento(detalleMovimiento.getTipoMovimiento());
                movimiento.setValor(detalleMovimiento.getValor());
                movimiento.setSaldo(detalleMovimiento.getSaldo());
                return movimientoRepository.save(movimiento);
            }).orElse(null);
    }

    @Override
    public void deleteMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }
}
