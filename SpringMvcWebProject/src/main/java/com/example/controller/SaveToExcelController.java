package com.example.controller;

import com.example.service.SaveToExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class SaveToExcelController {
    @Autowired
    SaveToExcelService saveToExcelService;
    @GetMapping("/saveToExcel")
    public String saveToExcel() throws IOException {
        System.out.println("save to excel ");
        saveToExcelService.saveToExcel();
        return "downloaded";
    }
}
