package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void writeExcel() throws IOException {
        String path = ".\\src\\test\\resources\\ULKELER.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);   //file'i acalim
        Workbook workbook = WorkbookFactory.create(fileInputStream);   //workbook'u acalim
        Sheet sheet = workbook.getSheetAt(0);  //1.sheet'e git
        Row row = sheet.getRow(0);  //1.row'a git  (basliklar)

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        Cell cell4 = row.createCell(3);  // create cell
        cell4.setCellValue("NUFUS");

        Cell cell5 = row.createCell(4);
        cell5.setCellValue("YUZOLCUMU");
        row.removeCell(cell5);  // cell'de bulunan veriyi siler.

        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("1232123456");  //2.satir icin
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("3232123456");  //3.satir
        workbook.getSheetAt(0).getRow(3).createCell(3).setCellValue("3212345678");  //4.satir


        workbook.write(fileOutputStream);  //cell'e veri yazar ve kaydeder.

        fileOutputStream.close();
        fileInputStream.close();
        workbook.close();

    }
}
