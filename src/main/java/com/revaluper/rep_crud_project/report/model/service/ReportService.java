package com.revaluper.rep_crud_project.report.model.service;

import com.revaluper.rep_crud_project.report.model.dao.ReportMapper;
import com.revaluper.rep_crud_project.report.model.dto.ReportDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    public final ReportMapper reportMapper;
    public ReportService(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    public List<ReportDTO> findReportList() {
        return reportMapper.findReportList();
    }

    @Transactional
    public void insertReport(ReportDTO newReport) {

        List<ReportDTO> reportList = new ArrayList<>();

        System.out.println(reportList);

        ReportMapper.insertReport(newReport);

    }

}
