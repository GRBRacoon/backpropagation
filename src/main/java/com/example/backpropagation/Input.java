package com.example.backpropagation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Input {
    private int num=10;
    private int sample=40;
    private int img=100;

    public int getNum() {
        return num;
    }

    public int getSample() {
        return sample;
    }

    public int getImg() {
        return img;
    }

    double[][][] result=new double[sample][num][img];

    double[][][] readAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\backProp\\train.txt"))) {
            for(int i=0;i<num;i++){
                for(int j=0;j<sample;j++){
                    String s=reader.readLine();
                    String line=reader.readLine();
                    String[] numArr=line.split(" ");//쉼표빼고 배열로 저장
                    for(int k=0;k<10;k++){
                        for(int c=0;c<10;c++){
                            int index=k*10+c;
                            System.out.println(j+" "+i+" "+index);
                            result[j][i][index]=Double.parseDouble(numArr[c]);
                            //숫자를 읽어서 저장
                        }

                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    double[][][] testRead() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\backProp\\test.txt"))) {
            for(int i=0;i<num;i++){
                for(int j=0;j<sample;j++){
                    String s=reader.readLine();
                    String line=reader.readLine();
                    String[] numArr=line.split(",");//쉼표빼고 배열로 저장
                    for(int k=0;k<img;k++){
                        result[j][i][k]=Double.parseDouble(numArr[k]);
                        //숫자를 읽어서 저장
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
