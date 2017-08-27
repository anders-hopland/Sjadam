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
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.SjadamGame.SjadamGame;
import com.mygdx.SjadamGame.Util.ScreenManager;
import com.mygdx.SjadamGame.Util.ScreenType;

/**
 * Created by Anders-Hopland on 29.07.2017.
 */

public class CreditsScreen extends AbstractScreen {

    private Stage stage;
    private TextButton button;
    private TextButton.TextButtonStyle textButtonStyle;
    private BitmapFont textFont;
    private BitmapFont buttonFont;
    private Skin skin;
    private TextureAtlas buttonAtlas;

    private Table table;

    private SpriteBatch spriteBatch;
    private Texture sjadamLogo;

    public CreditsScreen() {

        spriteBatch = new SpriteBatch();
        sjadamLogo = new Texture(Gdx.files.internal("sjadamLogo.png"));

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Roboto-Black.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 17;
        textFont = generator.generateFont(parameter);
        generator.dispose();

        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Roboto-Black.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 25;
        buttonFont = generator.generateFont(parameter);
        generator.dispose();

        //Buttonstyle
        stage = new Stage();
        stage.setViewport(viewport);
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("skins/quantum-horizon-ui.atlas"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = buttonFont;
        textButtonStyle.up = skin.getDrawable("button");
        textButtonStyle.down = skin.getDrawable("button-pressed");
        textButtonStyle.fontColor = Color.BLACK;

        //Buttons
        //Start game button
        button = new TextButton("BACK", textButtonStyle);
        button.setSize(SjadamGame.VIRTUAL_WIDTH / 1.4f, 100);
        button.setX((SjadamGame.VIRTUAL_WIDTH - (SjadamGame.VIRTUAL_WIDTH / 1.5f)) / 2);
        button.setY(100);
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

        //Text
        textFont.draw(spriteBatch, "- The chess pieces are taken from" +
                "  https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces, \n" +
                        "  and licensed under CC BY-CA 3.0 \n" +
                "\n" +
                "- Button skins are licensed under CC BY 4.0 \n" +
                        "  and made by Raymond \"Raeleus\" Buckley. \n" +
                "\n" +
                "Font license\n" +
                "Copyright 2017 Christian Robertson\n" +
                        "- Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                        "  you may not use this file except in compliance with the License.\n" +
                        "  You may obtain a copy of the License at\n" +
                        "    http://www.apache.org/licenses/LICENSE-2.0",
                20, 580, SjadamGame.VIRTUAL_WIDTH - 40, 1, true);


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
