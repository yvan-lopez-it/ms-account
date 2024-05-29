package com.devsu.challenge.backend.apirest.accountapp.service.impl;

import com.devsu.challenge.backend.apirest.accountapp.dto.ReporteResponse;
import com.devsu.challenge.backend.apirest.accountapp.entity.Cuenta;
import com.devsu.challenge.backend.apirest.accountapp.entity.Movimiento;
import com.devsu.challenge.backend.apirest.accountapp.enums.TipoMovimiento;
import com.devsu.challenge.backend.apirest.accountapp.repository.CuentaRepository;
import com.devsu.challenge.backend.apirest.accountapp.repository.MovimientoRepository;
import com.devsu.challenge.backend.apirest.accountapp.service.IReporteService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ReporteServiceImpl implements IReporteService {

    private final CuentaRepository cuentaRepository;

    private final MovimientoRepository movimientoRepository;

    public ReporteServiceImpl(CuentaRepository cuentaRepository, MovimientoRepository movimientoRepository) {
        this.cuentaRepository = cuentaRepository;
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public ReporteResponse generateReporte(String fechaInicio, String fechaFin, String clienteId) {
        LocalDate startDate = LocalDate.parse(fechaInicio);
        LocalDate endDate = LocalDate.parse(fechaFin);

        List<Cuenta> cuentas = cuentaRepository.findByClientId(clienteId);

        List<ReporteResponse.CuentaReporte> cuentasReporte = cuentas.stream()
            .map(cuenta -> {
                List<Movimiento> movimientos = movimientoRepository.findByCuentaIdAndFechaBetween(cuenta.getId(), startDate, endDate);

                double saldoInicial = cuenta.getSaldoInicial();
                double saldoFinal = calcularSaldoFinal(saldoInicial, movimientos);

                return new ReporteResponse.CuentaReporte(
                    cuenta.getId(),
                    cuenta.getTipoCuenta().toString(),
                    saldoInicial,
                    saldoFinal,
                    movimientos.stream()
                        .map(mov -> new ReporteResponse.MovimientoReporte(
                            mov.getFecha(),
                            mov.getTipoMovimiento().toString(),
                            mov.getValor(),
                            mov.getSaldo()
                        )).collect(Collectors.toList())
                );
            }).collect(Collectors.toList());

        return new ReporteResponse(clienteId, cuentasReporte);
    }

    private double calcularSaldoFinal(double saldoInicial, List<Movimiento> movimientos) {
        return movimientos.stream()
            .mapToDouble(mov -> TipoMovimiento.valueOf("DEPOSITO") == mov.getTipoMovimiento()
                ? mov.getValor()
                : -mov.getValor())
            .sum() + saldoInicial;
    }
}
