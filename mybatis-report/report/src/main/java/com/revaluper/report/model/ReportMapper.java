package com.revaluper.report.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {
    List<ReportDTO> selectAllReport(Map<String, List<Integer>> map);
}
