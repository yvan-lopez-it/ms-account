package com.devsu.challenge.backend.apirest.accountapp.service;

import com.devsu.challenge.backend.apirest.accountapp.dto.ReporteResponse;

public interface IReporteService {

    ReporteResponse generateReporte(String fechaInicio, String fechaFin, String clienteId);
}
