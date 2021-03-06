package com.exedo.ld.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.exedo.ld.LudumDare;

public class MainMenu implements Screen{
    private LudumDare game;

    OrthographicCamera cam;

    public MainMenu(LudumDare game) {
        this.game = game;

        cam = new OrthographicCamera();
        cam.setToOrtho(false, 1920, 1080);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.update();
        game.getBatch().setProjectionMatrix(cam.combined);

        game.getBatch().begin();
        game.getBatch().draw(SplashScreen.manager.get("mainmenu.png", Texture.class), 0, 0, cam.viewportWidth, cam.viewportHeight);
        game.getBatch().end();

        if(Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        SplashScreen.manager.unload("mainmenu.png");
    }
}
