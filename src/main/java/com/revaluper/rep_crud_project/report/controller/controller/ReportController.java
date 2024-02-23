package com.revaluper.rep_crud_project.report.controller.controller;

import com.revaluper.rep_crud_project.report.model.dto.ReportDTO;
import com.revaluper.rep_crud_project.report.model.service.ReportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;


@Controller
@RequestMapping("/report")
public class ReportController {

    private static final Logger logger = LogManager.getLogger(ReportController.class);

    private final ReportService reportService;

    private final MessageSource messageSource;

    public ReportController(ReportService reportService, MessageSource messageSource) {
        this.reportService = reportService;
        this.messageSource = messageSource;
    }

    @GetMapping("list")
    public String findReportList(Model model){

        List<ReportDTO> reportList = new ArrayList<>();

        reportList.add( new ReportDTO(1, "★테스트 1번★","테스트 1번입니다. 잘부탁드립니다.","2024-02-02","test1","N"));
        reportList.add( new ReportDTO(2, "★★테스트 2번★★","테스트 1번을 신고합니다.","2024-02-03","test2","N"));
        reportList.add( new ReportDTO(3, "★★★테스트 3번 ★★★","테스트 5번은 남자가 아니었어요","2024-02-05","test3","Y"));
        reportList.add( new ReportDTO(4, "★★★★테스트 4번★★★★","나는 잘 지내시죠?","2024-02-09","test4","N"));
        reportList.add( new ReportDTO(5, "★★★★★테스트 5번★★★★★","잘 안지냅ㄴ니다","2024-02-10","test5","Y"));

        reportList = reportService.findReportList();

        model.addAttribute("reportList", reportList);

        System.out.println(reportList);

        return "report/list";
    }

    @GetMapping("/insert")
    public void insertReport(){}

    public String insertReport(ReportDTO insertReport, RedirectAttributes rttr, Locale locale) {

        logger.info("Locale : {}", locale);

        reportService.insertReport(insertReport);
        rttr.addFlashAttribute("successMessage", messageSource.getMessage("insertreport", null,locale));

        return "redirect:/report/list";
    }

}
