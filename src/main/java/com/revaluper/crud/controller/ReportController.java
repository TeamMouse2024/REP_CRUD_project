package com.revaluper.crud.controller;

import com.revaluper.crud.Service.ReportService;
import com.revaluper.crud.dto.ReportDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ReportController {

    private final ReportService reportService;


    public ReportController(ReportService reportService, SqlSessionTemplate sql) {
        this.reportService = reportService;
    }

    @GetMapping("/save")    /* 주소 */
    public String save() {
        return "save";  /* 리턴할 화면의 이름 */
    }

    // 인서트
    @PostMapping("/save")
    public String save(ReportDTO reportDTO) {
        System.out.println(reportDTO);
        reportService.save(reportDTO);
        return "redirect:/list";
    }

    //조회
    @GetMapping("/list")
    public String findAllReport(Model model){

        List<ReportDTO> reportList = reportService.findAllReport();
        model.addAttribute("reportList", reportList);
        System.out.println("reportList : " + reportList);
        return "list";
    }

    @GetMapping("/{id}")  // id라는 이름으로 받겠다.
    public String findById(@PathVariable("id") String id, Model model){

        // 조회수(hits)
        reportService.updateHits(id);
        // 상세내용
        ReportDTO reportDTO = reportService.findById(id);
        model.addAttribute("report", reportDTO);
        System.out.println("reportDTO" + reportDTO);
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") String id, Model model){
        ReportDTO reportDTO = reportService.findById(id);
        model.addAttribute("report", reportDTO);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(ReportDTO reportDTO, Model model){
        reportService.update(reportDTO);
        ReportDTO reportDTO1 = reportService.findById(reportDTO.getRepId());
        model.addAttribute("report", reportDTO1);
        return "detail";
    }

    @GetMapping("/delete/{repId}")
    public String delete(@PathVariable("repId") String repId){
        reportService.delete(repId);
            return "redirect:/list";


    }

}