package com.devsu.challenge.backend.apirest.accountapp.controller;

import com.devsu.challenge.backend.apirest.accountapp.entity.Movimiento;
import com.devsu.challenge.backend.apirest.accountapp.service.IMovimientoService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    private final IMovimientoService movimientoService;

    public MovimientoController(IMovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping
    public List<Movimiento> getAllMovimientos() {
        return movimientoService.getAllMovimientos();
    }

    @PostMapping
    public Movimiento createMovimiento(@RequestBody Movimiento movimiento) {
        return movimientoService.createMovimiento(movimiento);
    }

    @GetMapping("/{id}")
    public Optional<Movimiento> getMovimientoById(@PathVariable Long id) {
        return movimientoService.getMovimientoById(id);
    }

    @PutMapping("/{id}")
    public Movimiento updateMovimiento(@PathVariable Long id, @RequestBody Movimiento movimientoDetails) {
        return movimientoService.updateMovimiento(id, movimientoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMovimiento(@PathVariable Long id) {
        movimientoService.deleteMovimiento(id);
    }

}
