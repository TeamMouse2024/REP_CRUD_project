package com.revaluper.crud.menu.model.dao;

import com.revaluper.crud.menu.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuDTO> findAllMenu();

    void registMenu(MenuDTO newMenu);

    void modifyReport(MenuDTO modiReport);

    void deleteReport(MenuDTO deleteDTO);
}
