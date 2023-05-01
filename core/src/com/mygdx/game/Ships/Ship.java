package com.mygdx.game.Ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

abstract public class Ship {
    private int life;
    private int maxLife;
    private int xPosition;
    private int yPosition;


    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    private String name;
    private int stamina;
    private int maxStamina;



    private Texture imgage;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Texture getImgage() {
        return imgage;
    }

    public void setImgage(Texture imgage) {
        this.imgage = imgage;
    }

    public Ship(String name, Texture picture) {
        setName(name);
        setImgage(picture);
    }

    public String  toString(){
        String className = this.getClass().getSimpleName();
        String vie = (isAlive()) ? "Alive" : "Dead";

        return String.format("%s : %s [ %s ] life: %d maxLife: %d stamina: %d maxStamina: %d", className,getName(), vie, getLife(),getMaxLife(), getStamina(), getMaxStamina());


    }


    /* Etat */

    boolean isAlive(){
        return getLife() > 0;
    }

    /*Action */
   abstract public void move();
}
