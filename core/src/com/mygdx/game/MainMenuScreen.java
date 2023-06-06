package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MainMenuScreen implements Screen {

    private Stage stage;
    private Skin skin;
    private SpriteBatch batch;
    private BitmapFont font;
    private TextButton newGameButton;
    private TextButton levelButton;

    public MainMenuScreen() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        stage = new Stage();
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("font.fnt"));
        newGameButton = new TextButton("Nouvelle Partie", skin);
        levelButton = new TextButton("Niveau", skin);
    }

    @Override
    public void show() {
        newGameButton.setPosition(Gdx.graphics.getWidth() / 2 - newGameButton.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        levelButton.setPosition(Gdx.graphics.getWidth() / 2 - levelButton.getWidth() / 2, Gdx.graphics.getHeight() / 2 - newGameButton.getHeight() - 20);
        newGameButton.addListener(new ClickListener() {
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                // Ajouter ici le code à exécuter lorsqu'on clique sur le bouton "Nouvelle Partie"
            }
        });
        levelButton.addListener(new ClickListener() {
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                // Ajouter ici le code à exécuter lorsqu'on clique sur le bouton "Niveau"
            }
        });
        stage.addActor(newGameButton);
        stage.addActor(levelButton);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
        batch.dispose();
        font.dispose();
    }
    public void pause(){

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    // Les autres méthodes de l'interface Screen ne sont pas nécessaires pour cet exemple

}
