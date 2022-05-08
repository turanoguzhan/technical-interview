package com.ouz.solution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int boy = scanner.nextInt();
         int en = scanner.nextInt();

         getMaxSquareInRectangle(boy,en);
    }

    private static void getMaxSquareInRectangle(int boy, int en){

        int kareKenar, kareSayi=0;

        while(boy>0 && en>0){

            if(boy > en){
                kareKenar = en;
                kareSayi += boy/kareKenar;
                boy = boy%kareKenar;
            }else{
                kareKenar = boy;
                kareSayi += en/kareKenar;
                en = en%kareKenar;
            }
        }

        System.out.println("Sonuc : "+kareSayi);
    }
}
