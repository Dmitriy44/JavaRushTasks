package com.javarush.test.level30.lesson15.big01.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dima on 27.10.2015.
 */
public class ClientGuiModel
{
    private final Set<String> allUserNames = new HashSet<>();
    private String newMessage;

    public Set<String> getAllUserNames()
    {
        return Collections.unmodifiableSet(allUserNames);
    }

    public void setNewMessage(String newMessage)
    {
        this.newMessage = newMessage;
    }

    public String getNewMessage()
    {
        return newMessage;
    }

    public void addUser(String newUserName)
    {
        allUserNames.add(newUserName);
    }

    public void deleteUser(String userName)
    {
        allUserNames.remove(userName);
    }
}