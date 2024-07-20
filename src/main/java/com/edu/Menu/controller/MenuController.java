package com.edu.Menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.Menu.model.MenuModel;
import com.edu.Menu.service.MenuService;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuservice;
	
	@PostMapping("/update")
    public ResponseEntity<MenuModel> updateMenu(@RequestParam String inputs) {
        try {
            MenuModel updatedModel = menuservice.updateMenu(inputs);
            return new ResponseEntity<>(updatedModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
