package com.mygdx.game.Ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.exceptions.InvalidPositionException;

public class Alien extends Ship{
    private static String DEFAULT_NAME = "Alien";
    private static int DEFAULT_LIFE = 50;
    private static int DEFAULT_MAXLIFE = 50;
    private static Texture DEFAULT_PICTURE = new Texture("sprites/ships/spco_small.png");

    private static int DEFAULT_XSPEED = 5;

    private int xSpeed;
    private int ySpeed;

    public int getxSpeed() {
        return xSpeed;
    }


    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public Alien(String name, int positionX, int positionY){
        super(name,DEFAULT_PICTURE);
        setLife(DEFAULT_LIFE);
        setMaxLife(DEFAULT_MAXLIFE);
        setxPosition(positionX);
        setyPosition(positionY);
        setxSpeed(DEFAULT_XSPEED);

    }

    public Alien(int positionX, int positionY) {
        this(DEFAULT_NAME,positionX, positionY); // nom par defaut
    }
    public Alien(int positionX) {
        super(DEFAULT_NAME,DEFAULT_PICTURE);
        setxPosition(positionX);
        setyPosition(Gdx.graphics.getHeight()  - this.getImgage().getHeight());
        setxSpeed(DEFAULT_XSPEED);
    }
    public Alien() {
        super(DEFAULT_NAME,DEFAULT_PICTURE);
        setxPosition(0);
        setyPosition(Gdx.graphics.getHeight()  - this.getImgage().getHeight());
        setxSpeed(DEFAULT_XSPEED);
    }
    public void move(){
        setxPosition(getxPosition() + getxSpeed());
        if(getxPosition()<0 || getxPosition() > Gdx.graphics.getWidth() - this.getImgage().getWidth())
            setxSpeed( - getxSpeed() );
    }

    public void move(int leftLimit, int rightLimit) throws InvalidPositionException{
        if(leftLimit < 0 || rightLimit > Gdx.graphics.getWidth() - this.getImgage().getWidth())
            throw new InvalidPositionException();
        setxPosition(getxPosition() + getxSpeed());
        if(getxPosition()<leftLimit || getxPosition() > rightLimit)
            setxSpeed( - getxSpeed() );
    }

}
