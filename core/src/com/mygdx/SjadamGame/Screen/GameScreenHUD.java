package com.mygdx.SjadamGame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.SjadamGame.Helpers.BOARD_COLOR;
import com.mygdx.SjadamGame.Util.ScreenType;

/**
 * Created by Anders-Hopland on 28.07.2017.
 */

public class GameScreenHUD {

    private Stage stage;
    private TextButton button;
    private TextButton.TextButtonStyle textButtonStyle;
    private BitmapFont font;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private Viewport viewport;
    private SpriteBatch spriteBatch;
    private boolean renderingGameOver;

    public GameScreenHUD(Viewport viewport, SpriteBatch spriteBatch) {
        this.viewport = viewport;
        this.spriteBatch = spriteBatch;
        renderingGameOver = false;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Roboto-Black.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 22;
        font = generator.generateFont(parameter);
        generator.dispose();


        //Buttonstyle
        stage = new Stage();
        stage.setViewport(viewport);
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("skins/quantum-horizon-ui.atlas"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("button");
        textButtonStyle.down = skin.getDrawable("button-pressed");
        textButtonStyle.fontColor = Color.BLACK;

        //Buttons
        //Pause game button
        button = new TextButton("Pause", textButtonStyle);
        button.setSize(com.mygdx.SjadamGame.SjadamGame.VIRTUAL_WIDTH / 3.5f, 70);
        button.setX(com.mygdx.SjadamGame.SjadamGame.VIRTUAL_WIDTH - 150f);
        button.setY(com.mygdx.SjadamGame.SjadamGame.VIRTUAL_HEIGHT - 110);
        stage.addActor(button);

        button.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                com.mygdx.SjadamGame.Util.ScreenManager.getScreenManager().showScreen(com.mygdx.SjadamGame.Util.ScreenType.PAUSE_SCREEN);
            }
        });
    }

    public void renderHUD() {
        stage.setViewport(viewport);
        stage.draw();
    }

    public void renderGameOver(BOARD_COLOR winnerColor) {
        spriteBatch.begin();
        font.draw(spriteBatch, "GAME OVER, " + winnerColor + " WON", 20, 90);
        spriteBatch.end();

        if (renderingGameOver == false) {
            button = new TextButton("NEW GAME", textButtonStyle);
            button.setSize(com.mygdx.SjadamGame.SjadamGame.VIRTUAL_WIDTH / 3f, 70);
            button.setX(com.mygdx.SjadamGame.SjadamGame.VIRTUAL_WIDTH - 180f);
            button.setY(30);
            stage.addActor(button);

            button.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    com.mygdx.SjadamGame.Util.ScreenManager.getScreenManager().showScreen(ScreenType.NEW_GAME_SCREEN);
                }
            });

            renderingGameOver = true;
        }
    }

    public Stage getStage() {
        return stage;
    }
}

