package com.devsu.challenge.backend.apirest.accountapp.service.impl;

import com.devsu.challenge.backend.apirest.accountapp.entity.Cuenta;
import com.devsu.challenge.backend.apirest.accountapp.repository.CuentaRepository;
import com.devsu.challenge.backend.apirest.accountapp.service.ICuentaService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements ICuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    @Override
    public Optional<Cuenta> getCuentaById(Long id) {
        return cuentaRepository.findById(id);
    }

    @Override
    public Cuenta createCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta updateCuenta(Long id, Cuenta detalleCuenta) {
        return cuentaRepository.findById(id)
            .map(cuenta -> {
                cuenta.setNumeroCuenta(detalleCuenta.getNumeroCuenta());
                cuenta.setTipoCuenta(detalleCuenta.getTipoCuenta());
                cuenta.setSaldoInicial(detalleCuenta.getSaldoInicial());
                cuenta.setEstado(detalleCuenta.isEstado());
                return cuentaRepository.save(cuenta);
            }).orElse(null);
    }

    @Override
    public void deleteCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }
}
