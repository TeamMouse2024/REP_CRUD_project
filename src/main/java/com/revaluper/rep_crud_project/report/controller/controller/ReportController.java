package com.revaluper.rep_crud_project.report.controller.controller;

import com.revaluper.rep_crud_project.report.model.dto.ReportDTO;
import com.revaluper.rep_crud_project.report.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    //요청이 들어왔을 때 실행되는 순서
    //controller -> service -> mapper(dao) -> xml
    //조회 - @GetMapping
    //저장 - @PostMapping
    //수정 - @PutMapping
    //삭제 - @DeleteMapping
    @ResponseBody
    @GetMapping
    public List<ReportDTO> findReportList() {
        System.out.println("신고게시판 전체조회 시작");
        List<ReportDTO> reportList = reportService.findAll();
        System.out.println("신고게시판 전체조회 끝");
        return reportList;
    }

    //단일 조회컨트롤러
    @ResponseBody
    @GetMapping("/{repId}")
    public ReportDTO findReport(@PathVariable String repId) {
        System.out.println("신고게시판 단일조회 시작 - 조회아이디 : " + repId);
        ReportDTO report = reportService.find(repId);
        System.out.println("신고게시판 단일조회 끝 - 조회아이디 : " + repId);
        return report;
    }
    //삭제
    @ResponseBody
    @DeleteMapping("/{repId}")
    public void deleteReport(@PathVariable String repId) {
        System.out.println("신고게시판 아이디 삭제 시작 - Id : " + repId);
        reportService.delete(repId);
        System.out.println("신고게시판 아이디 삭제 끝 - Id : " + repId);
    }
    //저장(insert)기능 추가
    @ResponseBody
    @PostMapping("/{repId}")
    public ReportDTO insertReport(@PathVariable String repId) {
        System.out.println("신고게시판 아이디 저장 시작 - Id : " + repId);
        ReportDTO report = reportService.insert(repId);
        System.out.println("신고게시판 아이디 저장 끝 - Id : " + repId);
        return  report;
    }

}
