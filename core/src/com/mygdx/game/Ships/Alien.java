package com.mygdx.game.Ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Alien extends Ship{
    private static String DEFAULT_NAME = "Alien";
    private static int DEFAULT_LIFE = 50;
    private static int DEFAULT_MAXLIFE = 50;
    private static Texture DEFAULT_PICTURE = new Texture("sprites/ships/spco_small.png");
    private  int DEFAULT_XPosition = Gdx.graphics.getWidth() - this.getImgage().getWidth();
    private  int DEFAULT_YPosition = Gdx.graphics.getHeight()  - this.getImgage().getHeight();

    private int xSpeed;
    private int ySpeed;

    @Override
    public int getxSpeed() {
        return xSpeed;
    }

    @Override
    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    @Override
    public int getySpeed() {
        return ySpeed;
    }

    @Override
    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public Alien(String name, int positionX, int positionY){
        super(name,DEFAULT_PICTURE);
        setLife(DEFAULT_LIFE);
        setMaxLife(DEFAULT_MAXLIFE);
        setxPosition(positionX);
        setyPosition(positionY);
        setxSpeed(10);
        setySpeed(10);
    }

    public Alien(int positionX, int positionY) {
        this(DEFAULT_NAME,positionX, positionY); // nom par defaut
    }
    public Alien() {
        super(DEFAULT_NAME,DEFAULT_PICTURE);
        setxPosition(Gdx.graphics.getWidth() - this.getImgage().getWidth());
        setyPosition(Gdx.graphics.getHeight()  - this.getImgage().getHeight());
        setxSpeed(5);
    }
    public void move(){
        setxPosition(getxPosition() + getxSpeed());
        if(getxPosition()<0 || getxPosition() > Gdx.graphics.getWidth() - this.getImgage().getWidth())
            setxSpeed( - getxSpeed() );
    }

    public void move(int leftLimit, int rightLimit){
        setxPosition(getxPosition() + getxSpeed());
        if(getxPosition()<leftLimit || getxPosition() > rightLimit)
            setxSpeed( - getxSpeed() );
    }

}
