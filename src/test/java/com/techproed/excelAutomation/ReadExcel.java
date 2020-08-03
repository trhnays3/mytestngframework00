package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {

    @Test
    public void readExcelFile() throws IOException {
        //Data okuyacagimiz dosyanin path'ini yazalim
        String path = "C:\\Users\\PC\\Desktop\\ULKELER.xlsx";
        //String path = ".\\src\\test\\resources\\ULKELER.xlsx";
        //Dosyayi(file) acalim
        FileInputStream fileInputStream = new FileInputStream(path);
        //fileInputStream kullanarak workbook'u acalim
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //1.worksheet'e gidelim (index 0'dan basliyor)
        Sheet sheet = workbook.getSheetAt(0);
        //1.satira (row) gidelim (index 0'dan baslar)
        Row row = sheet.getRow(0);
        //Artik test datalarini(cell) okuyabiliriz.
        Cell cell = row.getCell(0);

        System.out.println("1.CELL'deki data : "+cell);
        System.out.println("2.CELL'deki data : "+ row.getCell(1));

        //2.row'daki 1.cell'i konsolda yazdirin
        Row row2 = sheet.getRow(1);
        Cell cell1 = row2.getCell(0);
        System.out.println(cell1);   //Almanya
                            //chain metodu
        System.out.println(workbook.getSheetAt(0).getRow(1).getCell(0));
                            //chain metodu
        String row2cell1 = workbook.getSheetAt(0).getRow(1).getCell(0).toString();
        System.out.println(row2cell1);

        //Son row(satir) numarasini alalim.(index 0 dan baslar)
        int rowSayisi = sheet.getLastRowNum();
        System.out.println("Dosyadaki toplam satir sayisi :" +rowSayisi);  //13

        //Kullanilan(icinde veri olan) satirlarin sayisini nasil aliriz?(index 1 den baslar)
        int numberOfPhysicalRows = sheet.getPhysicalNumberOfRows();
        System.out.println(numberOfPhysicalRows);    //12

        Map<String, String > ulkeler = new HashMap<>();
        int ulkeColumn = 0;
        int baskentColumn = 1;
        for( int rowNum = 1 ; rowNum<= rowSayisi ; rowNum++){
            String ulke = sheet.getRow(rowNum).getCell(ulkeColumn).toString();
            System.out.print(ulke+"  ");
            String baskent = sheet.getRow(rowNum).getCell(baskentColumn).toString();
            System.out.println(baskent);

            //hashmap olarak konsolda nasil yazdirabilirim???
            ulkeler.put(ulke,baskent);
        }
        System.out.println(ulkeler);

    }
}
