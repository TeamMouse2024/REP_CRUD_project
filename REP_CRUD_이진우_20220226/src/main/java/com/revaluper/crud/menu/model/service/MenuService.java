package com.revaluper.crud.menu.model.service;

import com.revaluper.crud.menu.model.dao.MenuMapper;
import com.revaluper.crud.menu.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    public void registMenu(MenuDTO newMenu) {
        menuMapper.registMenu(newMenu);
    }

    public void modifyReport(MenuDTO modiReport) {
        menuMapper.modifyReport(modiReport);
    }

    public void deleteReport(MenuDTO deleteDTO) {
        menuMapper.deleteReport(deleteDTO);
    }
}
