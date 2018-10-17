package base;

import base.counter.FrameCounter;
import base.renderer.AnimationRenderer;
import base.renderer.Renderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics{
//    boolean isValidFire;
    FrameCounter fireCounter;
    BoxCollider collider;
    Vector2D velocity;


    public Player(){
        super();
        // load image thay cho tạo mảng và add ảnh
        this.renderer = new SingleImageRenderer("assets/image/snake2.png");
        this.position = new Vector2D();
        position.x = Setting.START_PLAYER_POSITION_X;
        position.y = Setting.START_PLAYER_POSITION_Y;
        this.velocity = new Vector2D(2,0);

        this.fireCounter = new FrameCounter(10);
        this.collider =  new BoxCollider(42,40);
    }

    public void move (int velocityX, int velocityY){
        velocity.setThis( (float)velocityX, (float)velocityY);
        this.velocity.setThis(clamp(velocity.x,-5,5),clamp(velocity.y,-5,5));
    }

    public float clamp(float number, float min, float max){
        return number < min ? min : number > max ? max : number;
    }
    int i=0;
    public void growUp(){
        Player player1 = GameObject.recycle(Player.class);
        player1.position.setThis(this.position.x ,this.position.y - 40*i);
        i++;
    }

    @Override
    public  void run (){
        if (KeyEventPress.isUpPress){
            this.move(0,-2);
        }
        if (KeyEventPress.isDownPress){
            this.move(0,2);
        }
        if (KeyEventPress.isRightPress){
            this.move(2,0);
        }
        if (KeyEventPress.isLeftPress){
            this.move(-2, 0);
        }
        this.position.addThis(velocity);

        Apple apple = GameObject.intersect(Apple.class,this);
        if(apple != null){
            apple.destroy();
            Apple apple1 = GameObject.recycle(Apple.class);
            apple1.generate();
            this.growUp();
        }
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
