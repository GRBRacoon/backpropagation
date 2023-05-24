package com.example.backpropagation;

import java.util.Arrays;

public class Backpropaganda {
    private int inSize=100;
    private int hSize=20;
    private int outSize=10;
    private double[][] w1 = new double[hSize][inSize+1];//1층 가중치
    private double[][] w2= new double[outSize][hSize+1];//2층가중치
    private double[] input =new double[inSize+1];
    private double[][] hidden=new double[2][hSize+1];
    private double[][] output= new double[2][outSize];
    private double[] err=new double[outSize];
    private double learnRate=0.5;

    int[] lastOut= new int[10];
    int sumAll=0;
    int correctAll=0;
    int unCorrectAll=0;
    int[] sum= new int[10];
    int[] correct=new int[10];

    public double getLearnRate() {
        return learnRate;
    }

    public void setLearnRate(double learnRate) {
        this.learnRate = learnRate/100;
    }

    public double[][] getOutput() {
        return output;
    }

    //생성자
    public Backpropaganda(){
       input[0]=1;
       hidden[0][0] =1;
       hidden[1][0]=1;
       initializeW1();
       initializeW1();
    }
    void initializeW1( ){ //1층 가중치 초기화
        for(int j=0;j<hSize;j++){
            for(int k=0;k<inSize+1;k++){//가중치에 막 값 집어넣기
                w1[j][k]=1-2*Math.random();//가중치는 -1-1
            }
        }
    }

    void initializeW2( ){//2층 가중치 초기화
        for(int j=0;j<outSize;j++){
            for(int k=0;k<hSize+1;k++){//가중치에 막 값 집어넣기
                w2[j][k]=1-2*Math.random();//가중치는 -1-1
            }
        }

    }
    //학습
    void learningOne(double[] result) { //각 숫자의 인덱스 100개 대상
        for (int i = 0; i < inSize; i++) {
            input[i + 1] = result[i];
        }
        for (int j = 1; j <= hSize; j++) {
            for (int k = 0; k < inSize; k++) {
                hidden[0][j]=hidden[0][j]+w1[j][k]*input[k];
            }
        }
    }
    void learningTwo(){//마지막 출력 10개 대상
        for(int j=0;j<outSize;j++){
            for(int k=1;k<=hSize;k++) {
                output[0][j] = output[0][j] + w2[j][k] * hidden[1][k];
            }
        }

    }

    void sigmoidH() {//hidden[0][]의 값들에 시그모이드
        for (int i = 1; i <= 10; i++) {
            this.hidden[1][i]= Math.exp(this.hidden[0][i]);
        }
    }
    void sigmoidO(){//output[0][]의 값들 시그모이드
        for (int i = 0; i < 10; i++) {
            this.output[1][i]= Math.exp(this.output[0][i]);
        }
    }
    void correctCheck(int ans){
        double com=0;
        int out=0;
        for(int i=0;i<outSize;i++){
            if(output[1][i]>com){
                out=i;
                com=output[1][i];
            }
        }
        if(ans==out){
            correct[ans]++;
            sum[ans]++;
        }
        else{
            sum[ans]++;
        }
        sumAll=sumAll+sum[ans];
        correctAll=correctAll+correct[ans];
    }


    void forward(double[][] result){//순전파/output까지 값을 집어넣고 틀렸는지까지 확인
            for(int j=0;j<10;j++){
                learningOne(result[10]);
                sigmoidH();
                learningTwo();
                sigmoidO();
                correctCheck(j);
            }
    }


    //테스팅을 기준으로 v값을 조정
    void backward(){//역전파// 가중치 조정만
        int t=0;
        for(int i=0;i<10;i++){//i는 타겟

            for(int j=0;j<10;j++){//타겟의 인덱스를 확인
                if(j==i)
                    t=1;
                weightCalW1(i,t);
                weightCalW2(i,t);
            }

        }
    }

    void errCal(int num){//num은 0-9까지// backward에 넣지말고 따로 한번 시행
        double target=0;
        for(int i=0;i<10;i++){
            if(i==num){
                target=1;
            }
            err[i]=1/2*Math.pow((target-output[1][i]),2);
        }
    }
    double weightCalW1(int tarNum,int t){//타겟 숫자 하나에 대해, w1[target][]을 계산
        for(int i=0;i<=hSize+1;i++){//t는 타겟 숫자의 타겟값
            double x=-(t-err[i]);
            double y=output[1][tarNum]*(1-output[1][tarNum]);
            double z=err[i];
            w1[tarNum][i] =w1[tarNum][i]-learnRate*(x+y+z);
        }
        return 0;
    }
    double weightCalW2(int tarNum,int t){
        for(int i=0;i<outSize;i++){
            double x=-(t-err[i]);
            double y=output[1][tarNum]*(1-output[1][tarNum]);
            double z=err[i];
            w2[tarNum][i] =w2[tarNum][i]-learnRate*(x+y+z);
        }
        return 0;
    }

}
