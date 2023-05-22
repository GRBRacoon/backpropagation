package com.example.backpropagation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Backpropaganda backpropaganda=new Backpropaganda();
        Input input=new Input();
        Scanner scanner= new Scanner(System.in);
        double[][][] result=input.readAll();//각 배열 인덱스, 40, 10, 100
        while(true) {
            int choice;

            System.out.println("메뉴를ㄹ 석택하세요.");
            System.out.println("학습   : 1");
            System.out.println("테스트 : 2");
            System.out.println("종료   : 3");
            //scanner
            choice= scanner.nextInt();
            float accuracy;


            //1
            if(choice==1) {

                System.out.print("원하는 정밀도를 입력하시오(0~100의 값): ");
                //SCANNER
                accuracy = scanner.nextFloat();//정확도 입력
                backpropaganda.setLearnRate(accuracy);//정확도 저장

                backpropaganda.forward(result); //순전

                for (int i = 0; i < input.getNum(); i++) {backpropaganda.errCal(i);}//오차계산

                backpropaganda.backward();//역전

                System.out.println(backpropaganda.getOutput()[1]);//결과 출력
            }
            //2
            else if(choice==2){
                backpropaganda.forward(result);

            }
            //3
            else if(choice==3){
                break;
            }
            else{
                System.out.println("잘못된 입력, 다시 입력하세요.");
            }
        }
    }


}
