package com.ohgiraffers.testapi.controller;

import com.ohgiraffers.testapi.model.dto.MenuDTO;
import com.ohgiraffers.testapi.model.dto.Message;
import com.ohgiraffers.testapi.model.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/list")
    public ResponseEntity<Message>findAllMenu(){

        HttpHeaders headers =new HttpHeaders();
        headers.setContentType(new MediaType("Application","json",Charset.forName("UTF-8")));

        List<MenuDTO> menuList = menuService.findAllMenu();

        Map<String, Object> res = new HashMap<>();

        res.put("menuList", menuList);

        return ResponseEntity.ok().headers(headers).body(new Message(200, "메뉴전체조회 성공!!", res));
    }


    @GetMapping("/detail/{menuCode}")
    public ResponseEntity<Message>findByMenuId(@PathVariable("menuCode") int menuCode){

        HttpHeaders headers =new HttpHeaders();
        headers.setContentType(new MediaType("Application","json",Charset.forName("UTF-8")));

        MenuDTO menuDTO = menuService.findByMenuId(menuCode);

        Map<String,Object> res = new HashMap<>();

        res.put("menuDTO", menuDTO);

        return ResponseEntity.ok().headers(headers).body(new Message(200,"메뉴상세조회 성공", res));
    }

    @PostMapping("/regist")
    public ResponseEntity<?>registMenu(@RequestBody MenuDTO menuDTO){

        menuService.registMenu(menuDTO);

        return ResponseEntity.created(URI.create("/menu/list")).body(new Message(200, "메뉴등록성공", null));

    }

}
