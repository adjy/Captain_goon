package com.mygdx.game.Ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Captain extends Ship{

    private static String DEFAULT_NAME = "Captain Goon";
    private static int DEFAULT_LIFE = 100;
    private static int DEFAULT_MAXLIFE = 100;
    private static Texture DEFAULT_PICTURE = new Texture("sprites/ships/blueships1_small.png");


    public Captain (String name){
        super(name,DEFAULT_PICTURE);
        setLife(DEFAULT_LIFE);
        setMaxLife(DEFAULT_MAXLIFE);
    }

    public Captain() {
        this(DEFAULT_NAME); // nom par defaut
    }

    public void move(){

        int positionX = Gdx.input.getX() - (this.getImgage().getWidth()/2);
        if(positionX > 0 && positionX < Gdx.graphics.getWidth() - getImgage().getWidth())
            setxPosition(positionX);
        else if(positionX > Gdx.graphics.getWidth() - getImgage().getWidth())
            setxPosition(Gdx.graphics.getWidth() - getImgage().getWidth());
        else
            setxPosition(0);


        int positionY = Gdx.graphics.getHeight() - Gdx.input.getY() - (this.getImgage().getHeight()/2); // Calculate paddle y position based on mouse position
        int maxY = (Gdx.graphics.getHeight()* 80) / 100;
//        int maxY = 0;

        if(positionY > 0 && positionY < Gdx.graphics.getHeight() - maxY)
            setyPosition(positionY);
        else if(positionY >  Gdx.graphics.getHeight() - maxY)
            setyPosition(Gdx.graphics.getHeight() - maxY);
        else
            setyPosition(0);

    }
}
