package com.example.service;

import com.example.entity.Role;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.example.dao.UserInfoDao;
import com.example.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaveToExcelService {
    @Autowired
    UserInfoDao userInfoDao;

    public void saveToExcel() throws IOException {
        List<UserInfo> userInfoList = userInfoDao.getAllUserInfo();

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet1");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("id");
        headerRow.createCell(1).setCellValue("name");
        headerRow.createCell(2).setCellValue("email");
        headerRow.createCell(3).setCellValue("mobile");
        headerRow.createCell(4).setCellValue("username");
        headerRow.createCell(5).setCellValue("password");
        headerRow.createCell(6).setCellValue("role");
        int rowIndex = 1;
        for (UserInfo user : userInfoList) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(user.getUserId());
            row.createCell(1).setCellValue(user.getUserName());
            row.createCell(2).setCellValue(user.getUserEmail());
            row.createCell(3).setCellValue(user.getUserMobile());
            row.createCell(4).setCellValue(user.getUserUserName());
            row.createCell(5).setCellValue(user.getUserPassword());
           String roles=user.getRoleList().stream()
                   .map(Role::getRoleName)
                   .collect(Collectors.joining(","));
           row.createCell(6).setCellValue(roles);
        }
        FileOutputStream fos = new FileOutputStream("/home/som/Desktop/java training/sql/SpringMvcWebProject/src/main/resources/excel/userinfo.xlsx");
        workbook.write(fos);
        workbook.close();
        System.out.println("data saved");
    }
}
