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
    public void modifyReport() {}

    @PostMapping("/modify")
    public String modifyReport(int repNo, String repTitle, String repContent, String repDate, String repId, String repPrc) {

        ReportDTO modiReport = new ReportDTO();
        modiReport.setRepNo(repNo);
        modiReport.setRepTitle(repTitle);
        modiReport.setRepContent(repContent);
        modiReport.setRepDate(repDate);
        modiReport.setRepId(repId);
        modiReport.setRepPrc(repPrc);

        reportService.modifyReport(modiReport);
        System.out.println("신고 내용 수정 완료!!!");

        System.out.println(modiReport);

        return "/main";
    }

    @GetMapping("/delete")
    public void deleteReport() {}

    @PostMapping("/delete")
    public String deleteReport(int repNo) {

        reportService.deleteReport(repNo);

        System.out.println("신고 내역 삭제 완료!!!");

        return "/main";
    }

}
