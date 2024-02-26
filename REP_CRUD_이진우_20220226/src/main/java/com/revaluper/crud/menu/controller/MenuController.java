package com.revaluper.crud.menu.controller;

import com.revaluper.crud.menu.model.dto.MenuDTO;
import com.revaluper.crud.menu.model.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public String findMenuList(Model model) {

        List<MenuDTO> menuList = menuService.findAllMenu();

        model.addAttribute("menuList", menuList);

        return "menu/list";
    }

    @GetMapping("/regist")
    public String registMenu(MenuDTO newMenu) {

//        newMenu = new MenuDTO(6, "신고제목", "신고내용입니다6", "20240218", "user06", "N");
        newMenu.setRepNo(6);
        newMenu.setRepTitle("신고6");
        newMenu.setRepContent("신고내용 6");
        newMenu.setRepDate("20240208");
        newMenu.setRepId("user06");
        newMenu.setRepPrc("승인");

        menuService.registMenu(newMenu);
        System.out.println(newMenu);

        return "menu/regist";
    }

    @GetMapping("/modify")
    public String modifyReport(Model model, MenuDTO modiReport) {

        modiReport.setRepTitle("신고제목2 수정2");
        modiReport.setRepContent("신고내용 수정입니다2");
        modiReport.setRepDate("20240623");
        modiReport.setRepId("dlwlsdn1234");
        modiReport.setRepPrc("Y");
        modiReport.setRepNo(2);

        menuService.modifyReport(modiReport);

        System.out.println("신고 내용 수정 완료!!!");

        System.out.println(modiReport);
        model.addAttribute("modiReport", modiReport);

        return "/menu/modify";
    }

    @GetMapping("/delete")
    public String deleteReport(MenuDTO deleteDTO) {

        deleteDTO.setRepNo(5);
        menuService.deleteReport(deleteDTO);


        System.out.println("신고 내용 삭제 완료!!!");


        return "/menu/delete";
    }
}
