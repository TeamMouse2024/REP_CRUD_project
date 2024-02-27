package com.revaluper.rep_crud_project.report.controller.controller;

import com.revaluper.rep_crud_project.report.model.dto.ReportDTO;
import com.revaluper.rep_crud_project.report.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RequestMapping에 아무것도 적지 않으면 기본적으로
//http://{domain} , 지금 현재 서버주소 = localhost
//http://localhost:8080
@Controller
@RequestMapping("/report") //http://localhost:8080/report
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    //요청이 들어왔을 때 실행되는 순서
    //controller -> service -> mapper(dao) -> xml

    //아래 매핑은 그냥 관례. -> 꼭 지킬필요는 없어.
    //하지만 거의 대부분 99% 아래처럼 사용해. 참고 : rest api
    //GET, POST, PUT, DELETE 이런걸 HTTP METHOD라고 한다.

    //조회 - @GetMapping
    //저장 - @PostMapping
    //수정 - @PutMapping
    //삭제 - @DeleteMapping

    //하나의 요청 =  HTTP METHOD + URL + Data


    // 화면을 보여주려면
    // 1.@ResponseBody를 제거.
    // 2.리턴을 String으로 변환.
    // 3.리턴값에는 보여주고자 하는 html의 경로.
    // 4.메서드에서 모델객체(Model)를 받아서 model.addAttribute("html에서 사용할이름", 넣어줄객체)
    //GET + http://localhost:8080/report
    @GetMapping()
    public String findReportList(Model model) {
        System.out.println("신고게시판 전체조회 시작");
        List<ReportDTO> reportList = reportService.findAll();
        System.out.println("신고게시판 전체조회 끝");
        model.addAttribute("reportList", reportList);
        return "report/reportlist";
    }

    //GET + http://localhost:8080/report/신고번호
    //단일 조회컨트롤러
    @ResponseBody
    @GetMapping("/{repNo}")
    public ReportDTO findReport(@PathVariable String repNo) {
        System.out.println("신고게시판 단일조회 시작 - 신고번호 : " + repNo);
        ReportDTO report = reportService.find(repNo);
        System.out.println("신고게시판 단일조회 끝 - 신고번호 : " + repNo);
        return report;
    }

    //DELETE + http://localhost:8080/report/삭제할아이디
    //@PathVariable은 경로를 뜻한다.
    //삭제
    @ResponseBody
    @DeleteMapping("/{repNo}")
    public void deleteReport(@PathVariable String repNo) {
        System.out.println("신고게시판 아이디 삭제 시작 - Id : " + repNo);
        reportService.delete(repNo);
        System.out.println("신고게시판 아이디 삭제 끝 - Id : " + repNo);
    }

    //POST + http://localhost:8080/report/insert
    //POST는 body에 데이터를 전달해야 한다.
    //저장(insert)기능 추가
    @ResponseBody
    @PostMapping("/insert") //PostMapping은 데이터를 body로 보내야함.
    public void insertReport(@RequestBody ReportDTO report) {
        System.out.println("신고게시판 데이터 삽입 시작 - 저장할 데이터 :"+ report.toString());
        reportService.save(report);
        System.out.println("신고게시판 데이터 삽입 끝");
    }

    /**
     * DB에 PK, UK 는 유일값 -> 고로 테이블에 PK는 하나고 2개이상 같은값이 저장 불가.
     * 그래서 DB에 저장(insert)할때는 저장하기 전에 해당 저장 값이 있는지 조회 하고 있으면 이미 데이터가 있다고 에러를 내야해.
     *
     * 수정도 마찬가지로 데이터가 있어야 수정하는거니까 수정 전에 먼저 조회하고 수정. 없다면 에러 ex) 데이터가 존재하지 않습니다.
     */

    @ResponseBody
    @PutMapping("/update")
    public void updateReprot(@RequestBody ReportDTO report) {
        System.out.println("신고게시판 데이터 수정 시작 - 저장할 데이터 :"+ report.toString());
        reportService.update(report);
        System.out.println("신고게시판 데이터 수정 끝");
    }
}
