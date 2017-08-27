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

/**
 * Created by Anders-Hopland on 09.08.2017.
 */

public class HowToPlayScreen extends AbstractScreen {
    private Stage stage;
    private TextButton button;
    private TextButton.TextButtonStyle textButtonStyle;
    private BitmapFont font;
    private Skin skin;
    private TextureAtlas buttonAtlas;

    private SpriteBatch spriteBatch;
    private Texture sjadamLogo;

    public HowToPlayScreen() {

        spriteBatch = new SpriteBatch();
        sjadamLogo = new Texture(Gdx.files.internal("sjadamLogo.png"));

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Roboto-Black.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 16;
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
        button = new TextButton("BACK", textButtonStyle);
        button.setSize(com.mygdx.SjadamGame.SjadamGame.VIRTUAL_WIDTH / 1.4f, 100);
        button.setX((com.mygdx.SjadamGame.SjadamGame.VIRTUAL_WIDTH - (com.mygdx.SjadamGame.SjadamGame.VIRTUAL_WIDTH / 1.5f)) / 2);
        button.setY(100);
        stage.addActor(button);

        button.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                com.mygdx.SjadamGame.Util.ScreenManager.getScreenManager().showScreen(com.mygdx.SjadamGame.Util.ScreenType.START_SCREEN);
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
        spriteBatch.draw(sjadamLogo, com.mygdx.SjadamGame.SjadamGame.VIRTUAL_WIDTH / 2 - 55, 620, 110, 110);

        //Text
        font.draw(spriteBatch, "Click a piece to see all the possible moves" +
                        "\n\nA sjadamjump is represented by a blue tile" +
                        "\n\nA regular chess move is represented by a pink tile" +
                        "\n\nCastling is represented by a orange tile" +
                        "\n\nIf you choose to only take a sjdamjump, click on the red tile underneath your piece",
                20, 580, com.mygdx.SjadamGame.SjadamGame.VIRTUAL_WIDTH - 40, 1, true);

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
