package com.revaluper.crud.report.controller;

import com.revaluper.crud.report.model.dto.ReportDTO;
import com.revaluper.crud.report.model.service.ReportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.SecureRandom;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService, MessageSource messageSource) {
        this.reportService = reportService;
    }

    @GetMapping("/list")
    public String findAllReport(Model model) {

        List<ReportDTO> reportList = reportService.findAllReport();
        System.out.println("reportList : " + reportList + "\n");
        model.addAttribute("reportList", reportList);

        return "report/list";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @PostMapping("/regist")
    public String registMenu(ReportDTO newReport, RedirectAttributes rttr, Locale locale) {

        newReport = new ReportDTO(6, "신고제목", "신고내용입니다6", "20240218", "user06", "N");
        reportService.registReport(newReport);
        System.out.println(rttr.addAttribute("신고가 새로 등록되었습니다."));
        System.out.println(newReport);
//        rttr.addFlashAttribute("successMessage", "신규 메뉴를 등록하였습니다.");

        return "redirect:/report/regist";
    }

    @GetMapping("/modify")
    public String modifyReport(Model model, ReportDTO modiReport) {

        modiReport.setRepTitle("신고제목2 수정");
        modiReport.setRepContent("신고내용 수정입니다2");
        modiReport.setRepDate("20240127");
        modiReport.setRepId("user002");
        modiReport.setRepPrc("Y");
        modiReport.setRepNo(2);

        reportService.modifyReport(modiReport);

        System.out.println("신고 내용 수정 완료!!!");

        System.out.println(modiReport);
        model.addAttribute("modiReport", modiReport);


        return "/report/list";
    }
}
