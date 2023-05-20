package com.example.backpropagation;

public class Backpropaganda {
    //input[10][100];11개
    //hidden 11개
    //output 10개
    //계수 v[2][11][11]
    //target 1=100...2=010....
    //파일을

    private double[][][] v = new double[2][11][11];
    private double[] input =new double[11];
    private double[] hidden=new double[11];
    private double[] output= new double[10];
    //생성자

    public Backpropaganda(){
       input[0]=1;
       initializing();
    }
    void initializing(){
        for(int i=0;i<2;i++){
            for(int j=0;j<11;j++){
                for(int k=0;k<11;k++){
                    //가중치에 막 값 집어넣기
                }
            }
        }
    }

    //학습
    void runningOne(double[] result) {
        for (int i = 0; i < 10; i++) {
            input[i + 1] = result[i];
        }

        hidden[0] = 1;
        for (int j = 1; j <= 10; j++) {
            for (int k = 1; k <= 10; k++) {
                hidden[j] = hidden[j] + v[0][j][k] * input[k];
            }
        }
    }

    void sigmoidH() {
        for (int i = 1; i <= 10; i++) {//hidden이 시그모이드 함수를 지나감
            this.hidden[i]= Math.exp(this.hidden[i]);
        }
    }
    void sigmoidO(){
        for (int i = 0; i < 10; i++) {//hidden이 시그모이드 함수를 지나감
            this.output[i]= Math.exp(this.output[i]);
        }
    }
    void runningTwo(){
        for(int i=0;i<40;i++){//표본이 400개이므로 40회 반복
            for(int j=1;j<=10;j++){
                for(int k=1;k<=10;k++) {
                    output[j] = output[j] + v[1][j][k] * hidden[k];
                }
            }
        }
    }

    void forward(double[] result){
        runningOne(result);
        sigmoidH();
        runningTwo();
        sigmoidO();
    }

    //테스팅을 기준으로 v값을 조정
    void backward(){

    }

}
