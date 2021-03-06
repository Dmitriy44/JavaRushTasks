package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

/**
 * Created by Dima on 04.02.2016.
 */
public class Model
{
    public static final int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("//res//levels.txt"));

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects()
    {
        return gameObjects;
    }

    public void restartLevel(int level)
    {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart()
    {
        restartLevel(currentLevel);
    }

    public void startNextLevel()
    {
        currentLevel++;
        this.restart();
    }

    public void move(Direction direction)
    {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction))
        {
            return;
        }
        if (checkBoxCollision(direction))
        {
            return;
        }
        int x = FIELD_SELL_SIZE;
        switch (direction)
        {
            case LEFT:
                gameObjects.getPlayer().move(-x, 0);
                break;
            case RIGHT:
                gameObjects.getPlayer().move(x, 0);
                break;
            case UP:
                gameObjects.getPlayer().move(0, -x);
                break;
            case DOWN:
                gameObjects.getPlayer().move(0, x);
                break;
        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction)
    {
        for (Wall wall : gameObjects.getWalls())
        {
            if (gameObject.isCollision(wall, direction))
            {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction)
    {
        Player player = gameObjects.getPlayer();
        int x1 = player.getX();
        int y1 = player.getY();
        int count = FIELD_SELL_SIZE;
        switch (direction){
            case LEFT:
                x1 = x1-count;
                break;
            case RIGHT:
                x1 = x1+count;
                break;
            case UP:
                y1 = y1-count;
                break;
            case DOWN:
                y1 = y1+count;
        }

        GameObject  stoped = null;
        for (GameObject gameObject: gameObjects.getAll()){
            if (((x1 == gameObject.getX()) &&(y1 == gameObject.getY())) && !(gameObject instanceof Player)&& !(gameObject instanceof Home)){
                stoped = gameObject;
            }
        }

        if ((stoped == null)){
            return false;
        }
        if (stoped instanceof Box){
            Box stopedBox = (Box)stoped;
            if (checkWallCollision(stopedBox,direction)){
                return true;
            }
            for (Box box : gameObjects.getBoxes()){
                if(stopedBox.isCollision(box,direction)){
                    return true;
                }
            }
            switch (direction)
            {
                case LEFT:
                    stopedBox.move(-count, 0);
                    break;
                case RIGHT:
                    stopedBox.move(count, 0);
                    break;
                case UP:
                    stopedBox.move(0, -count);
                    break;
                case DOWN:
                    stopedBox.move(0, count);
            }
        }
        return false;
    }

    public void checkCompletion()
    {
        int count = 0;
        for (Home home : gameObjects.getHomes())
        {
            for (Box box : gameObjects.getBoxes())
            {
                if (home.getX() == box.getX() && home.getY() == box.getY())
                {
                    count++;
                }
            }
        }
        if (count >= gameObjects.getHomes().size())
        {
            eventListener.levelCompleted(currentLevel);
        }
    }
}
