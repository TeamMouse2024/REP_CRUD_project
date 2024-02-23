package com.revaluper.report.report;

import com.revaluper.report.model.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ReportApplication {

    @Autowired
    private ReportService reportService;



}
