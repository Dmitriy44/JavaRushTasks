package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Dima on 08.11.2015.
 */
public class Waitor implements Observer
{
    @Override
    public void update(Observable o, Object arg)
    {
        if (arg instanceof Order && o instanceof Cook)
        {
            Cook cook = (Cook) o;
            Order order = (Order) arg;

            ConsoleHelper.writeMessage(order + " was cooked by " + cook);
        }
    }
}
