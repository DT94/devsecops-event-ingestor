package com.devsecops.siem.Siem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScanReportRepository extends JpaRepository<ScanReport, Long> {
}