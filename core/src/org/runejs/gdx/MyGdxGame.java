package org.runejs.gdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;
import org.runejs.Configuration;
import org.runejs.client.Game;
import org.runejs.client.MovedStatics;
import org.runejs.client.RSCanvas;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.util.Signlink;
import org.runejs.client.util.Timer;

import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;

public class MyGdxGame extends ApplicationAdapter {
    private Texture dropImage;
    private Texture bucketImage;
	private Rectangle bucket;
    private OrthographicCamera camera;
    private OrthographicCamera hudCamera;
    private SpriteBatch batch;
	private BitmapFont font;
	private Game game;


    @Override
    public void create() {
		game = new Game(new String[]{});

		Game.gameCanvas = new Canvas();

		try {
			MovedStatics.signlink = Game.signlink = new Signlink(true, null, InetAddress.getByName(Configuration.SERVER_ADDRESS), 32 + Game.modewhat, "client435", 13);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		game.startup();
		game.gameTimer = Timer.create();


//		try {
//
//			main.openClientApplet("client435", 13, 32 + Class44.modewhat, InetAddress.getByName(Configuration.SERVER_ADDRESS), 435);
//		} catch (Exception e){
//
//		}


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

		hudCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		hudCamera.position.set(hudCamera.viewportWidth / 2.0f, hudCamera.viewportHeight / 2.0f, 1.0f);
        batch = new SpriteBatch();
        dropImage = new Texture(Gdx.files.internal("drop.png"));
        bucketImage = new Texture(Gdx.files.internal("bucket.png"));
		bucket = new Rectangle();
		bucket.x = 800 / 2 - 64 / 2;
		bucket.y = 20;
		bucket.width = 64;
		bucket.height = 64;

		font = new BitmapFont(Gdx.files.internal("default.fnt"));

	}

    @Override
    public void render() {
		System.out.println("Loop");
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();


		hudCamera.update();
		batch.setProjectionMatrix(hudCamera.combined);
		batch.begin();
		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 0, hudCamera.viewportHeight);
		batch.end();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(bucketImage, bucket.x, bucket.y);
		batch.end();
		game.processGameLoop();
		System.out.println("Status Text");
		game.updateStatusText();
		System.out.println("Finished loop");
    }

    @Override
    public void dispose() {
        batch.dispose();
		game.close();
    }
}
