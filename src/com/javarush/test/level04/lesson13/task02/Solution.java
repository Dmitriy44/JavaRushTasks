package com.javarush.test.level04.lesson13.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String s1,s2,s3="";
        int m,n;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s1=reader.readLine();
        s2=reader.readLine();
        m=Integer.parseInt(s1);
        n=Integer.parseInt(s2);
        for (int j=0; j<n; j++){
            s3=s3+"8";
        }
        for (int i=0; i<m; i++){
            System.out.println(s3);

        }

    }
}
