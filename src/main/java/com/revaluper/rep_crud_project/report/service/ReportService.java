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
    public ReportDTO find(String repNo) {
        return reportMapper.findReport(repNo);
    }

    //삭제
    public void delete(String repNo) {
        reportMapper.deleteReport(repNo);
    }

    //저장
    public void save(ReportDTO report) {
        reportMapper.insertReport(report);
    }
    //업데이트
    public void update(ReportDTO report) {
        reportMapper.updateReport(report);
    }
}
