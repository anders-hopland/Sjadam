package com.mygdx.game.Screen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Helpers.Board;
import com.mygdx.game.SjadamGame;

/**
 * Created by Anders-Hopland on 08.06.2017.
 */

public class GameScreen extends ApplicationAdapter implements Screen, InputProcessor {

    private SjadamGame game;
    private ShapeRenderer renderer;
    private Board board;

    private Viewport viewport;
    private OrthographicCamera camera;

    private SpriteBatch spriteBatch;


    public GameScreen(SjadamGame game) {
        this.game = game;
        this.renderer = new ShapeRenderer();
        this.board = new Board();



        camera = new OrthographicCamera();
        viewport = new FitViewport(SjadamGame.VIRTUAL_WIDTH, SjadamGame.VIRTUAL_HEIGHT, camera);
        viewport.setScreenBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(viewport.getWorldWidth() / 2, viewport.getScreenHeight() / 2, 0);

        spriteBatch = new SpriteBatch();
    }

    @Override
    public void show() {

    }

    public void handleInput(float delta) {
        //clicking
    }

    @Override
    public void render(float delta) {
        viewport.getCamera().update();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        board.renderBoard(renderer, viewport.getScreenHeight(), viewport.getScreenHeight());
        renderer.end();

        spriteBatch.begin();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        board.renderPieces(spriteBatch, (int)viewport.getWorldHeight(), (int)viewport.getWorldHeight());
        spriteBatch.end();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.update();
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

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Vector2 newPoints = viewport.unproject(new Vector2(screenX, screenY));

        System.out.println(screenX + "" + screenY);

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
