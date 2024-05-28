package com.devsu.challenge.backend.apirest.accountapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movimientos", schema = "public")
public class Movimiento implements Serializable {

    @Serial
    private static final long serialVersionUID = -1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El tipo de movimiento no puede estar vacio")
    @Column(nullable = false)
    private String tipoMovimiento;

    @NotBlank(message = "El valor no puede estar vacio")
    @Column(nullable = false)
    private Double valor;

    @NotBlank(message = "El saldo no puede estar vacio")
    @Column(nullable = false)
    private Double saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id")
    @JsonIgnoreProperties(value = {"transactions", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    private Cuenta cuenta;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.fecha = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

}
