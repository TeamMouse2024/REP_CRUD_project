package com.revaluper.rep_crud_project.report.controller.controller;

import com.revaluper.rep_crud_project.report.model.dto.ReportDTO;
import com.revaluper.rep_crud_project.report.model.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/main")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    public String findReportList(Model model){

        List<ReportDTO> reportList = reportService.findAllList();


        return reportList;
    }
}
