package com.revaluper.crud.report.model.dao;

import com.revaluper.crud.report.model.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {

    List<ReportDTO> findAllReport();

    void registReport(ReportDTO newReport);

    void modifyReport(ReportDTO modiReport);

    void deleteReport(int repNo);
}
