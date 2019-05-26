package vn.codegym.bookmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import vn.codegym.bookmanager.entity.Storage;
import vn.codegym.bookmanager.service.StorageService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StorageController {
    @Autowired
    StorageService storageService;

    @GetMapping("/storage")
        public String storage(ModelMap modelMap){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<Storage> storages = storageService.findAddStorageBook();
        modelMap.addAttribute("storage",storages);
        return "testShowStorage";

    }
}
