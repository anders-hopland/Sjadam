package com.mygdx.SjadamGame;

import com.badlogic.gdx.Game;
import com.mygdx.SjadamGame.Util.ScreenManager;
import com.mygdx.SjadamGame.Util.ScreenType;

public class SjadamGame extends Game {
	public static final int VIRTUAL_WIDTH = 480;
	public static final int VIRTUAL_HEIGHT = 750;
	public static final int BOARD_WIDTH = 480;
	public static final int BOARD_HEIGHT = 480;

	@Override
	public void create () {
		ScreenManager.getScreenManager().initialize(this);
		ScreenManager.getScreenManager().showScreen(ScreenType.START_SCREEN);
	}

	@Override
	public void render () {
		super.render();
	}
}


