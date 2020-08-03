package com.techproed.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Priority_DependsOnMethod {

      /* TestNG de test metodlari alfabetik siraya gore calisir.
      Yukaridan asagiya dogru calismaz.
      Test caseleri oncelik sirasina koymak icin "priority" annotation'ini kullaniriz.
      Eger ayni priority numarasi verilirse alfabetik siraya gore yurutulur.
     */


    @Test(priority = 1)
    public void login(){
        System.out.println("Bu metod login metodu");

    }

    @Test(priority = 2,dependsOnMethods = "login")
    public void homePage(){
        System.out.println("Bu metod homepage metodu");

    }

    @Test(priority = 3)
    public void search(){
        System.out.println("Bu metod search metodu");

    }

    @Test(priority = 4, dependsOnMethods = "search")
    public void result(){
        System.out.println("Bu metod result metodu");

    }
}
