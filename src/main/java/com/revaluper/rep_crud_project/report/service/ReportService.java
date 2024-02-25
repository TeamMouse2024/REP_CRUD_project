package com.revaluper.rep_crud_project.report.service;

import com.revaluper.rep_crud_project.report.dao.ReportMapper;
import com.revaluper.rep_crud_project.report.model.dto.ReportDTO;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ReportService {
    private final ReportMapper reportMapper;

    public ReportService(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    public List<ReportDTO> findAll() {
        return reportMapper.findAllReport();
    }

    //단일조회
    public ReportDTO find(String repId) {
        return reportMapper.findReport(repId);
    }
    //삭제
    public void delete(String repId) {
        reportMapper.deleteReport(repId);
    }
}
