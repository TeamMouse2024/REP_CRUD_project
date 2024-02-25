package com.revaluper.rep_crud_project.report.dao;

import com.revaluper.rep_crud_project.report.model.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {
    //신고게시판 모두조회
    List<ReportDTO> findAllReport();

    //신고게시판 단일조회
    ReportDTO findReport();

    //신고게시판 등록
    void registReport(ReportDTO newReport);

    //신고게시판 수정
    int updateReport();

    //신고게시판 삭제
    int deleteReport();

}



