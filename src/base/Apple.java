package base;

import base.renderer.SingleImageRenderer;

import java.util.Random;

public class Apple extends GameObject implements Physics {
    BoxCollider collider;

    public Apple(){
        super();
        this.renderer = new SingleImageRenderer("assets/image/apple3.png");
        this.position = new Vector2D(10,10);
        this.collider = new BoxCollider(42,40);
    }

    Random randomX = new Random();
    Random randomY = new Random();
    public void generate(){
        this.position = new Vector2D(randomX.nextInt(Setting.SCREEN_WIDTH - 40), randomY.nextInt(Setting.SCREEN_HEIGHT -40));
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }

}
