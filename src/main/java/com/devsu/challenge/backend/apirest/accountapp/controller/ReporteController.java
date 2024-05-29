package com.devsu.challenge.backend.apirest.accountapp.controller;

import com.devsu.challenge.backend.apirest.accountapp.dto.ReporteResponse;
import com.devsu.challenge.backend.apirest.accountapp.service.IReporteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    private final IReporteService reporteService;

    public ReporteController(IReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping
    public ReporteResponse getReporte(@RequestParam String fechaInicio, @RequestParam String fechaFin, @RequestParam String clienteId) {
        return reporteService.generateReporte(fechaInicio, fechaFin, clienteId);
    }

}
