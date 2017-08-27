package com.mygdx.SjadamGame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.SjadamGame.Helpers.BOARD_COLOR;
import com.mygdx.SjadamGame.Helpers.Board;
import com.mygdx.SjadamGame.SjadamGame;

/**
 * Created by Anders-Hopland on 08.06.2017.
 */

public class GameScreen extends AbstractScreen implements InputProcessor {

    private ShapeRenderer renderer;
    private Board board;

    private SpriteBatch spriteBatch;
    private Texture sjadamLogo;

    private com.mygdx.SjadamGame.Screen.GameScreenHUD hud;

    public GameScreen() {
        super();
        this.renderer = new ShapeRenderer();
        this.board = new Board();

        sjadamLogo = new Texture(Gdx.files.internal("sjadamLogo.png"));

        spriteBatch = new SpriteBatch();
        hud = new com.mygdx.SjadamGame.Screen.GameScreenHUD(viewport, spriteBatch);

        InputProcessor inputProcessor = new InputProcessor() {
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
                // Unproject touch to game coordinates
                Vector2 touch = viewport.unproject(new Vector2(screenX, screenY));
                touch.x = (int)((touch.x - (60 + touch.x % 60) + 60) / 60);
                touch.y = (int)((touch.y - (60 + touch.y % 60) + 60) / 60) - 2;

                if (board.getPlaying() == true) {
                    board.pieceClicked(touch);
                }

                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
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
        };
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(hud.getStage());
        inputMultiplexer.addProcessor(inputProcessor);
        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    @Override
    public void render(float delta) {

        viewport.getCamera().update();
        viewport.apply();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        board.renderBoard(renderer, SjadamGame.BOARD_WIDTH, SjadamGame.BOARD_HEIGHT);
        renderer.end();

        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();
        board.renderPieces(spriteBatch, SjadamGame.BOARD_WIDTH, SjadamGame.BOARD_HEIGHT);
        spriteBatch.draw(sjadamLogo, SjadamGame.VIRTUAL_WIDTH / 2 - 55, 620, 110, 110);
        spriteBatch.end();

        hud.renderHUD();

        //if not playing, draw game over and who won
        if (board.getPlaying() == false) {
            hud.renderGameOver(board.getWinnerColor());
        }
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

    //functions to save and restore game state

    public void setPieces(com.mygdx.SjadamGame.Helpers.Pieces.IPiece[][] pieces) {
        board.setPieceList(pieces);
    }

    public com.mygdx.SjadamGame.Helpers.Pieces.IPiece[][] getPieces() {
        return board.getPieceListAndResetPiece();
    }

    public void setPlayingColor(BOARD_COLOR playingColor) {
        board.setPlayerTurn(playingColor);
    }

    public BOARD_COLOR getPlayingColor() {
        return board.getPlayerTurn();
    }
}





