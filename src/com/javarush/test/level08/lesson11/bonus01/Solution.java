package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException, ParseException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        DateFormat now = new SimpleDateFormat("MMMM",Locale.US);
        Date dat=now.parse(reader.readLine());
        String str=now.format(dat);
        DateFormat now2 = new SimpleDateFormat("MM");
        String dat2=now2.format(dat);
        int i=Integer.parseInt(dat2);
        System.out.println(str+" is "+i+" month");
    }

}
