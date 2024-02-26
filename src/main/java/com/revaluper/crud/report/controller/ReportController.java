package com.revaluper.crud.report.controller;

import com.revaluper.crud.report.model.dto.ReportDTO;
import com.revaluper.crud.report.model.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
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
    public void registReport() {}

    @PostMapping("/regist")
    public String registReport(ReportDTO report) {

        reportService.registReport(report);

        System.out.println(report);
        System.out.println("신고가 새로 등록되었습니다.");

        return "/report/regist";
    }

    @GetMapping("/modify")
    public String modifyReport(Model model, ReportDTO modiReport) {

        modiReport.setRepTitle("신고제목2 수정");
        modiReport.setRepContent("신고내용 수정입니다2");
        modiReport.setRepDate("20240127");
        modiReport.setRepId("user002");
        modiReport.setRepPrc("승인");
        modiReport.setRepNo(2);

        System.out.println("신고 내용 수정 완료!!!");
        reportService.modifyReport(modiReport);

        System.out.println(modiReport);
        model.addAttribute("modiReport", modiReport);

        return "/report/modify";
    }

    @GetMapping("/delete")
    public String deleteReport(Model model, ReportDTO repNo) {
        repNo.setRepNo(6);

        reportService.deleteReport(repNo.getRepNo());
        System.out.println("신고 내역 삭제 완료!!!");


        model.addAttribute("repNo", repNo);

        return "/main";
    }

}
