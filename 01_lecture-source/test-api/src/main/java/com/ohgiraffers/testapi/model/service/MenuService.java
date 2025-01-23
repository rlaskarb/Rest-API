package com.ohgiraffers.testapi.model.service;

import com.ohgiraffers.testapi.model.dao.MenuRepository;
import com.ohgiraffers.testapi.model.dto.MenuDTO;
import com.ohgiraffers.testapi.model.entity.Menu;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {


    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    public List<MenuDTO> findAllMenu() {

        List<Menu> menuList = menuRepository.findAll();

        return menuList.stream().map(menu -> modelMapper.map(menu,MenuDTO.class)).collect(Collectors.toList());
    }

    public MenuDTO findByMenuId(int menuCode) {

        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(menu,MenuDTO.class);

    }

    public void registMenu(MenuDTO menuDTO) {

        menuRepository.save(modelMapper.map(menuDTO, Menu.class));
    }
}
