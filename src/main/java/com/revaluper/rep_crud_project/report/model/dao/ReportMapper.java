package com.revaluper.rep_crud_project.report.model.dao;

import com.revaluper.rep_crud_project.report.model.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ReportMapper {
    List<ReportDTO> findReportList();

    static void insertReport(ReportDTO newReport) {
    }

}
