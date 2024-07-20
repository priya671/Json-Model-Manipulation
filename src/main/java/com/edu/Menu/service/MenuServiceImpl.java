package com.edu.Menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.Menu.model.MenuItem;
import com.edu.Menu.model.MenuModel;
import com.edu.Menu.model.Menu;
import com.edu.Menu.model.Popup;
import com.edu.Menu.repository.MenuRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;
import com.edu.Menu.dao.MenuEntity;
import com.edu.Menu.err.GlobalException;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuRepository menurepository;
	
	private ObjectMapper objectmapper = new ObjectMapper();
	
	private MenuModel menumodel;
	
	public MenuServiceImpl() {
        // Initialize the predefined JSON model
        menumodel = new MenuModel();
        Menu menu = new Menu();
        menu.setId("file");
        menu.setValue("File");

        Popup popup = new Popup();
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("New", "CreateDoc()"));
        menuItems.add(new MenuItem("Open", "OpenDoc()"));
        menuItems.add(new MenuItem("Save", "SaveDoc()"));
        popup.setMenuitem(menuItems);

        menu.setPopup(popup);
        menumodel.setMenu(menu);
    }


	@Override
	public MenuModel updateMenu(String inputs) throws Exception{
		// TODO Auto-generated method stub
		String[] keyValuePairs = inputs.split(",");
        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":::");
            String key = keyValue[0];
            String value = keyValue[1];

            // Perform the replacement within the JSON model
            replaceInModel(menumodel, key, value);
        }
     // Convert MenuModel to JSON string
        String jsonModel = objectmapper.writeValueAsString(menumodel);

        // Save to database
        MenuEntity entity = new MenuEntity();
        entity.setJsonModel(jsonModel);
        menurepository.save(entity);

        return menumodel;
        
	}
	
	
	private void replaceInModel(MenuModel model, String key, String value) {
        Menu menu = model.getMenu();
        if (menu.getValue().equals(key)) {
            menu.setValue(value);
        }

        for (MenuItem item : menu.getPopup().getMenuitem()) {
            if (item.getValue().equals(key)) {
                item.setValue(value);
            }
        }
    }
	
	

}
