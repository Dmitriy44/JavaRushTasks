package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Dima on 04.05.2015.
 */
public class BelarusianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 400;
    }
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - "+ Country.BELARUS+". Я несу "+getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
