package com.mygdx.SjadamGame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.SjadamGame.SjadamGame;

/**
 * Created by Anders-Hopland on 22.07.2017.
 */

public abstract class AbstractScreen extends Stage implements Screen {

    protected OrthographicCamera camera;
    protected Viewport viewport;

    public AbstractScreen() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(SjadamGame.VIRTUAL_WIDTH, SjadamGame.VIRTUAL_HEIGHT, camera);
        viewport.setScreenBounds(Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight());
        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
