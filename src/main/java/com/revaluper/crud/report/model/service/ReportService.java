package com.revaluper.crud.report.model.service;

import com.revaluper.crud.report.model.dao.ReportMapper;
import com.revaluper.crud.report.model.dto.ReportDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReportService {

    private final ReportMapper reportMapper;

    public ReportService(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    public List<ReportDTO> findAllReport() {
        return reportMapper.findAllReport();
    }

    @Transactional
    public void registReport(ReportDTO newReport) {
        reportMapper.registReport(newReport);
    }

    public void modifyReport(ReportDTO modiReport) {
        reportMapper.modifyReport(modiReport);
    }

    public void deleteReport(int repNo) {
        reportMapper.deleteReport(repNo);
    }
}
