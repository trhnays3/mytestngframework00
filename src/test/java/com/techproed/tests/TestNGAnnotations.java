package com.techproed.tests;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeMethod // Her test metodundan once calisir.
    public void beforeMethod(){
        System.out.println("========Before Method=========");
    }
    @BeforeClass //Sadece classin basinda bir defa calisir
    public void BeforeClass(){
        System.out.println("=========Before Class=========");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("=========Before Test=======");
    }


    @Test
    public void test1(){
        System.out.println("BU Test1 Metodudur");

    }

    @Test
    public void test2(){
        System.out.println("Bu Test2 Metodudur");

    }

    @Ignore  // Test metodlarini gozmezden gelir. @Test annotation'i yoksa Ignore calismaz.
    @Test
    public void test3(){
        System.out.println("Bu Test3 Metodudur");

    }
    @AfterMethod  // Her test metodundan sonra calisir. 3 defa
    public void afterMethod(){
        System.out.println("========After Method========");
    }

    @AfterClass // Classin sonunda sedece bir defa calisir.
    public void afterClass(){
        System.out.println("=========After Class========");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("========After Test==========");
    }


}
