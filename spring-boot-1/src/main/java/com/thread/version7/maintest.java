package com.thread.version7;

import com.test.AddButtThread;

public class maintest {


    public static void main(String[] args) throws InterruptedException {

        SingleButtle singleButtle = SingleButtle.getInstance();
        if (singleButtle.getNum()<=31){
           while (true){
            new maintest().getTest();
           }
           }


    }


    public void getTest() throws InterruptedException {
        AddButtThread addButtThread = new AddButtThread();
        DecButtThread decButtThread = new DecButtThread();
        SingleButtle singleButtle = SingleButtle.getInstance();



        decButtThread.start();

       // Thread.sleep(2000);

        addButtThread.start();

    }
}
