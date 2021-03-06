package com.javarush.test.level27.lesson09.home01;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        System.out.println("Got: " + value);
        notifyAll();
        try
        {
            wait();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return value;
    }

    public synchronized void put(int value) {
        this.value = value;
        notifyAll();
        System.out.println("Put: " + value);
        try
        {
            wait();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
