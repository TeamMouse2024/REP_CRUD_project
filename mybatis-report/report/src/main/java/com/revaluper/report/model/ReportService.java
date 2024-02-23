package com.revaluper.report.model;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ReportService {

    private ReportMapper reportMapper;

    public ReportService(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;

    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void selectReport(ReportDTO reportInfo) {

        List<Integer> reportCodes = reportInfo.getReportList()
                .stream()
                .map(ReportDTO::getRepNo)
                .collect(Collectors.toList());

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("reportCodes", reportCodes);

        List<ReportDTO> report = reportMapper.selectAllReport(map);

        System.out.println(report);



    }
}
