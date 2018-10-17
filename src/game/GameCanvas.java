package game;


import base.Apple;
import base.GameObject;
import base.Player;
import javax.swing.*;
import java.awt.*;



//canvas bảng vẽ - panel
public class GameCanvas extends JPanel {
    Player player;
    Apple apple;

    //hàm khởi tạo GameCanvas
    public GameCanvas(){

        // khởi tạo player

        player = GameObject.recycle(Player.class);
        apple = GameObject.recycle(Apple.class);
    }


    // hàm run : hàm để update even khi có thay đổi về số liệu  (x += 1)
    // run phụ trách logic thay đổi dữ liệu

    public void run(){
        // run al : chạy tất cả object đc add vào list static gameObjects
        GameObject.runAll();
    }


    //render là bút vẽ sau khi số liệu đc update (g.draw)
    // chỉ phụ trách vẽ

    public void render (Graphics g){
    //tương tự như run
        GameObject.renderAll(g);
    }


    //painComponent : là hàm vẽ các thay đổi
    // graphics : đóng vai trò là bút vẽ, là 1 phần trong Jpanel

    @Override
    protected void paintComponent(Graphics g) {
        // gom tất cả các phần vẽ trong render để vẽ
        this.render(g);
    }
}
