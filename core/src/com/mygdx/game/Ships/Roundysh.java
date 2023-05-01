package com.mygdx.game.Ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.exceptions.InvalidPositionException;

public class Roundysh extends Alien{
    private static int DEFAULT_XPOSITION;
    private static int DEFAULT_YPOSITION;
    private static String DEFAULT_NAME = "Roundysh";
    private static Texture Picture = new Texture("sprites/ships/roundysh_small.png");
    private  int initPositionx;

    public Roundysh(int positionX, int positionY){
        super(DEFAULT_NAME, positionX, positionY);
        setImgage(Picture);
        this.initPositionx = getxPosition();
    }

    public Roundysh(){
        super();
        setName(DEFAULT_NAME);
        setImgage(Picture);
        this.initPositionx = getxPosition();
    }
    public Roundysh(int positionX){
        super(positionX);
        setName(DEFAULT_NAME);
        setImgage(Picture);
        this.initPositionx = getxPosition();
    }

    @Override
    public void move()  {
        int deb = 0, fin = Gdx.graphics.getWidth()/2 - this.getImgage().getWidth();
        if(initPositionx > Gdx.graphics.getWidth()/2 ) {
            deb = Gdx.graphics.getWidth() / 2;
            fin = initPositionx;
        }

        try {
            super.move(  deb,fin);
        }
        catch (InvalidPositionException e){
            super.move();
        }
    }
}
