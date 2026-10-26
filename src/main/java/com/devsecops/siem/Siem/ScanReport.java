package com.devsecops.siem.Siem;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "scan_reports")
public class ScanReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String objetivo;
    
    private LocalDateTime fechaRecepcion;

    @Column(columnDefinition = "TEXT")
    private String resultadosJson;

    public ScanReport() {}

    public ScanReport(String objetivo, String resultadosJson) {
        this.objetivo = objetivo;
        this.resultadosJson = resultadosJson;
        this.fechaRecepcion = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getObjetivo() { return objetivo; }
    public LocalDateTime getFechaRecepcion() { return fechaRecepcion; }
    public String getResultadosJson() { return resultadosJson; }
}