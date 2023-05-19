package com.example.backpropagation;

public class Backpropaganda {
    //input[10][100];11개
    //hidden 11개
    //output 10개
    //계수 v[2][11][11]
    //target 1=100...2=010....
    //파일을
    int i=1;
    private float[][][] v = new float[2][11][11];
    private float[] input =new float[11];
    private float[] hidden=new float[11];
    private float[] output= new float[10];
    //생성자

    public Backpropaganda(Input in) {
        input[0]=1;
        for(int i=0;i<10;i++){
            input[i+1]=in.result[i];
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<11;j++){
                for(int k=0;k<11;k++){
                    //가중치에 막 값 집어넣기
                }
            }
        }
    }


    //학습
    void runnig(){
        for(int i=0;i<40;i++){//표본이 400개이므로 40회 반복
            hidden[0]=1;
            for(int j=1;j<=10;j++){
                for(int k=1;k<=10;k++) {
                    hidden[i] = hidden[i] + v[1][j][k] * input[j];
                }
            }
        }


        for(int i=1;i<=10;i++){//hidden이 시그모이드 함수를 지나감

        }

    }
    //테스팅
    //테스팅을 기준으로 v값을 조정


}
