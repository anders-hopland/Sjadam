package com.mygdx.SjadamGame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.SjadamGame.SjadamGame;
import com.mygdx.SjadamGame.Util.ScreenManager;
import com.mygdx.SjadamGame.Util.ScreenType;

/**
 * Created by Anders-Hopland on 24.07.2017.
 */

public class PauseScreen extends AbstractScreen {

    private Stage stage;
    private TextButton button;
    private TextButton.TextButtonStyle textButtonStyle;
    private BitmapFont font;
    private Skin skin;
    private TextureAtlas buttonAtlas;

    private SpriteBatch spriteBatch;
    private Texture sjadamLogo;

    public PauseScreen() {

        spriteBatch = new SpriteBatch();
        sjadamLogo = new Texture(Gdx.files.internal("sjadamLogo.png"));

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
        //Start game button
        button = new TextButton("RESUME", textButtonStyle);
        button.setSize(SjadamGame.VIRTUAL_WIDTH / 1.4f, 100);
        button.setX((SjadamGame.VIRTUAL_WIDTH - (SjadamGame.VIRTUAL_WIDTH / 1.5f)) / 2);
        button.setY(SjadamGame.VIRTUAL_HEIGHT - 250);
        stage.addActor(button);

        button.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                ScreenManager.getScreenManager().showScreen(ScreenType.RESUME_GAME_SCREEN);
            }
        });

        //Rules button
        button = new TextButton("NEW GAME", textButtonStyle);
        button.setSize(SjadamGame.VIRTUAL_WIDTH / 1.4f, 100);
        button.setX((SjadamGame.VIRTUAL_WIDTH - (SjadamGame.VIRTUAL_WIDTH / 1.5f)) / 2);
        button.setY(SjadamGame.VIRTUAL_HEIGHT - 375);
        stage.addActor(button);

        button.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                ScreenManager.getScreenManager().showScreen(ScreenType.NEW_GAME_SCREEN);
            }
        });

        //Open sjadam website
        button = new TextButton("MAIN MENU", textButtonStyle);
        button.setSize(SjadamGame.VIRTUAL_WIDTH / 1.4f, 100);
        button.setX((SjadamGame.VIRTUAL_WIDTH - (SjadamGame.VIRTUAL_WIDTH / 1.5f)) / 2);
        button.setY(SjadamGame.VIRTUAL_HEIGHT - 500);
        stage.addActor(button);

        button.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                ScreenManager.getScreenManager().showScreen(ScreenType.START_SCREEN);
            }
        });

    }

    @Override
    public void render(float delta) {
        viewport.getCamera().update();
        viewport.apply();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();
        spriteBatch.draw(sjadamLogo, SjadamGame.VIRTUAL_WIDTH / 2 - 55, 620, 110, 110);
        spriteBatch.end();

        stage.draw();


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
}
