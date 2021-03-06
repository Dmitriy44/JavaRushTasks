package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Dima on 08.11.2015.
 */
public class Cook extends Observable implements Observer
{
    private final String name;

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        Order order = (Order) arg;
        if (!order.isEmpty())
        {
            ConsoleHelper.writeMessage("Start cooking - " + arg + ", cooking time " + order.getTotalCookingTime() + "min");
            StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));
            setChanged();
            notifyObservers(arg);
        }
    }
}
