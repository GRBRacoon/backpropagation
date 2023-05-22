package com.example.backpropagation;

public class Main {

    public static void main(String[] args) {
        Backpropaganda backpropaganda=new Backpropaganda();
        Input input=new Input();
        double[][][] result=input.readAll();//각 배열 인덱스, 40, 10, 100


        for(int i=0;i<input.getSample();i++){//숫자 하나 선택
            for(int j=0;j<input.getNum();j++){//40회 반복
                backpropaganda.forward(result[i][j]);
            }
        }

    }


}
