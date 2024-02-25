package com.revaluper.crud.Repository;

import com.revaluper.crud.dto.ReportDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportRepository {
    /* db 연동하는 코드 */
    /* JPA */

    private final SqlSessionTemplate sql;

    public ReportRepository(SqlSessionTemplate sql) {
        this.sql = sql;
    }

    public void save(ReportDTO reportDTO){
        sql.insert("Report.save", reportDTO);   // 쿼리문을 담고있는 ID
    }

    public List<ReportDTO> findAllReport(){
        return sql.selectList("Report.findAllReport");
    }


    public void updateHits(String id) {
        sql.update("Report.updateHits", id);
    }

    public ReportDTO findById(String id) {
        return sql.selectOne("Report.findById", id);
    }

    public void update(ReportDTO reportDTO) {
        sql.update("Report.update", reportDTO);
    }

    public void delete(String repId) {
        sql.delete("Report.delete", repId);
    }
}
