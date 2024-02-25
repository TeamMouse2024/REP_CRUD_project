package com.revaluper.rep_crud_project.report.controller.controller;

import com.revaluper.rep_crud_project.report.model.dto.ReportDTO;
import com.revaluper.rep_crud_project.report.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @ResponseBody
    @GetMapping
    public List<ReportDTO> findReportList(){
        List<ReportDTO> reportList = reportService.findAll();
        return reportList;
    }


}
