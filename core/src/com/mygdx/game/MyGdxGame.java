package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Ships.Alien;
import com.mygdx.game.Ships.Captain;
import com.mygdx.game.Ships.Roundysh;
import com.mygdx.game.Ships.Ship;
import com.mygdx.game.exceptions.InvalidPositionException;

public class MyGdxGame extends ApplicationAdapter {
	Texture imgBackgroung;
	SpriteBatch batch;
	String GAME_NAME = "Captain Goon";
	Captain captain;
	Alien alien;
	Roundysh roundysh;
	Roundysh roundysh2;
	Texture captainPicture ;
	Texture alienPicture;
//	private VideoPlayer videoPlayer;
	private Texture videoTexture;

	/*Screen */
	private void screen(){
		// Modifier la taille de l'écran à 800x600 pixels
//		Gdx.graphics.setWindowSize(1, 800);
		Gdx.graphics.setTitle(GAME_NAME);
		Gdx.graphics.setResizable(false);
		imgBackgroung = new Texture("backgrounds/Planets.jpg");
//		font.setColor(Color.WHITE);
	}


	public void create () {
		screen();

		batch = new SpriteBatch();
		captain = new Captain("Sedar");
		alien = new Alien();
		roundysh = new Roundysh();
		roundysh2 = new Roundysh(Gdx.graphics.getWidth());
		roundysh2.setxPosition(Gdx.graphics.getWidth()-roundysh2.getImgage().getWidth());
		captainPicture =  new Texture("sprites/ships/blueships1_small.png");
		alienPicture = new Texture("sprites/ships/spco_small.png");


		System.out.println(captain);
		System.out.println(alien);
		int a = 0;

		System.out.println( (a +10) % 20 );

	}
	public void lifeStats(Texture captainPicture, int captainStat,  Texture alienPicture, int alienStat){
		BitmapFont captainLife = new BitmapFont();
		BitmapFont alienLife = new BitmapFont();

		batch.draw( captainPicture,0,15, 40,40);
		captainLife.draw(batch, String.format("%d %%",captainStat), 50, 40);

		batch.draw( alienPicture,Gdx.graphics.getWidth() - 40,15, 40,40);
		alienLife.draw(batch, String.format("%d %%",alienStat),  Gdx.graphics.getWidth() - 2*40, 40);

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		batch.begin();
		batch.draw(imgBackgroung, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		batch.draw(captain.getImgage(),captain.getxPosition(),captain.getyPosition());
		batch.draw(alien.getImgage(), alien.getxPosition(),alien.getyPosition(), alien.getImgage().getWidth()/2, alien.getImgage().getHeight()/2, alien.getImgage().getWidth(), alien.getImgage().getHeight(), 1, 1, 180, 0, 0, alien.getImgage().getWidth(), alien.getImgage().getHeight(), false, false);

		batch.draw(roundysh.getImgage(), roundysh.getxPosition(),roundysh.getyPosition(), roundysh.getImgage().getWidth()/2, roundysh.getImgage().getHeight()/2, roundysh.getImgage().getWidth(), roundysh.getImgage().getHeight(), 1, 1, 180, 0, 0, roundysh.getImgage().getWidth(), roundysh.getImgage().getHeight(), false, false);
		batch.draw(roundysh2.getImgage(), roundysh2.getxPosition(),roundysh2.getyPosition(), roundysh2.getImgage().getWidth()/2, roundysh2.getImgage().getHeight()/2, roundysh2.getImgage().getWidth(), roundysh2.getImgage().getHeight(), 1, 1, 180, 0, 0, roundysh2.getImgage().getWidth(), roundysh2.getImgage().getHeight(), false, false);

//		batch.draw(alien.getImgage(),alien.getxPosition(),alien.getyPosition());

		captain.move();
		roundysh.move();
		roundysh2.move();


		try {
			alien.move(0, Gdx.graphics.getWidth() - alien.getImgage().getWidth());
//			roundysh.move(Gdx.graphics.getWidth()/2, Gdx.graphics.getWidth() - alien.getImgage().getWidth());




		}
		catch (InvalidPositionException e){
			alien.move();
			roundysh.move();


			e.printStackTrace();

		}

		lifeStats(captainPicture,captain.getLife(),alienPicture,captain.getLife());
//
//		System.out.println("Screen X: " + Gdx.graphics.getWidth() + " x position: "+ alien.getxPosition());

		captain.setLife(captain.getLife() - 1);

		batch.end();
	}
	@Override
	public void dispose () {
		batch.dispose();
		imgBackgroung.dispose();
	}



}
