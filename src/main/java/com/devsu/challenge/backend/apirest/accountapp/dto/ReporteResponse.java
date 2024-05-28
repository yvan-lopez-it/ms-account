package com.devsu.challenge.backend.apirest.accountapp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReporteResponse {

    private String clienteId;
    private List<CuentaReporte> cuentas;

    public ReporteResponse(String clienteId, List<CuentaReporte> cuentas) {
        this.clienteId = clienteId;
        this.cuentas = cuentas;
    }

    public static class CuentaReporte {
        private Long cuentaId;
        private String tipo;
        private double saldoInicial;
        private double saldoFinal;
        private List<MovimientoReporte> movimientos;

        public CuentaReporte(Long cuentaId, String tipo, double saldoInicial, double saldoFinal, List<MovimientoReporte> movimientos) {
            this.cuentaId = cuentaId;
            this.tipo = tipo;
            this.saldoInicial = saldoInicial;
            this.saldoFinal = saldoFinal;
            this.movimientos = movimientos;
        }
    }

    public static class MovimientoReporte {
        private LocalDateTime fecha;
        private String tipo;
        private double monto;
        private double saldo;

        public MovimientoReporte(LocalDateTime fecha, String tipo, double monto, double saldo) {
            this.fecha = fecha;
            this.tipo = tipo;
            this.monto = monto;
            this.saldo = saldo;
        }
    }


}
