package com.devsecops.siem.Siem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ingest")
public class ScanController {

    @Autowired
    private ScanReportRepository scanReportRepository;

    @PostMapping("/scan")
    public ResponseEntity<String> receiveScanReport(@RequestBody ScanReport payload) {
        try {
            // Guardamos el reporte en la base de datos
            scanReportRepository.save(payload); 
            return ResponseEntity.ok("Reporte de seguridad almacenado con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al procesar el payload: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> obtenerReportes() {
        return ResponseEntity.ok(scanReportRepository.findAll());
    }
}