package com.ohgiraffers.transactional.annotation;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RegistOrderService {

    private MenuMapper menuMapper;

    public RegistOrderService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public void registNewOrder(OrderDTO orderInfo) {

        List<Integer> menuCodes = orderInfo.getOrderMenus()
                                            .stream()
                                            .map(OrderMenuDTO::getMenuCode)
                                            .collect(Collectors.toList());

        /*
        List<Integer> menuCodes = new ArrayList<>();
        for(int i = 0; i < orderInfo.getOrderMenus().size(); i++) {
            menuCodes.add(orderInfo.getOrderMenus().get(i).getMenuCode());
        }
        */

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("menuCodes", menuCodes);

        List<Menu> menus = menuMapper.findMenusByMenuCode(map);

    }

}
