package com.thread.version7;

public class AddButtThread extends Thread {

    //增加子弹

    @Override
    public void run() {

        SingleButtle singleButtle = SingleButtle.getInstance();

        while (true){

            if (singleButtle.getNum()>=30){
                break;
            }

        singleButtle.setNum(singleButtle.getNum()+1);

        System.out.println(singleButtle.getNum());


        }


    }

}
