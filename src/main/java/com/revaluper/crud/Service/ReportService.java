package com.revaluper.crud.Service;

import com.revaluper.crud.Repository.ReportRepository;
import com.revaluper.crud.dto.ReportDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void save(ReportDTO reportDTO) {
        reportRepository.save(reportDTO);
    }

    public List<ReportDTO> findAllReport() {
        return reportRepository.findAllReport();
    }


    public void updateHits(String id) {
        reportRepository.updateHits(id);
    }

    public ReportDTO findById(String id) {
        return reportRepository.findById(id);
    }

    public void update(ReportDTO reportDTO) {
        reportRepository.update(reportDTO);
    }

    public void delete(String repId) {
        reportRepository.delete(repId);
    }
}
