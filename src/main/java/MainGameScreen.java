import com.raylib.Raylib;

import java.util.ArrayList;

import static com.raylib.Colors.*;
import static com.raylib.Colors.WHITE;
import static com.raylib.Raylib.*;

public class MainGameScreen extends  Screen{
    private  ArrayList<Enemy> enemies;
    private  Player p;
    private  final Raylib.Vector2 rectDim = new Raylib.Vector2().x(20.0f).y(20.0f);
    private int score;
    public MainGameScreen(int width, int height) {

        Raylib.Vector2 pos = new Raylib.Vector2();
        pos.x(GetScreenWidth()/2);
        pos.y(GetScreenHeight()/2);
        this(width,height, new Player(pos, new Raylib.Vector2().x(20.0f).y(20.0f), 100.0f,ORANGE));

    }

    public MainGameScreen(int width, int height, Player p) {
        super(width,height);

        this.p = p;
        enemies = new ArrayList<>();
        Refresh(Utils.GetRandomInt(1,100));
        score = 0;
    }

    public  void Refresh(int am) {
        for(int i = 0; i<am; i++) {
            float ranx = Utils.GetRandomFloat(0.0f, GetScreenWidth());
            float randy = Utils.GetRandomFloat(0.0f, GetScreenHeight());
            Rectangle r = new Rectangle(new Vector2().x(ranx).y(randy), rectDim, RED);
            Rectangle zone = new Rectangle(p.GetPos(), new Vector2().x(p.GetDim().x()*9).y(p.GetDim().y()*9), RED);
            if(zone.IsColliding(r)) {continue;}
            Vector2 randPos = new Vector2().x(ranx).y(randy);
            int rand = Utils.GetRandomInt(2);
            if(rand == 0) {
                enemies.add(new ShootingEnemy(randPos, rectDim, Utils.GetRandomFloat(0.005f), BLUE, p));
            } else {
                enemies.add(new NormalEnemy(randPos, rectDim, Utils.GetRandomFloat(0.005f), BLUE, p ));
            }
        }
    }

    @Override
    public void Draw() {
        BeginDrawing();
        ClearBackground(BLACK);
        p.Draw();
        for(Enemy e: enemies) {
            e.Draw();
        }
        DrawText(String.valueOf(score), GetScreenWidth()/2, GetScreenHeight()-(GetScreenHeight()/2), 20, WHITE);
        EndDrawing();
    }

    @Override
    public void Update() {
        if(p.getHealth() <= 0.0f) {Main.SetScreen(new GameOverScreen(width,height, this.score)); return;}
        if(enemies.isEmpty()) {
            //Refresh(Utils.GetRandomInt(100));
            Main.SetScreen(new ShopScreen(width,height, p));
            return;
        }
        for(int i = enemies.size()-1; i>=0; i--) {
            if(enemies.get(i).IsColliding(p.GetRect())) {
                p.DecHealth(1.0f);
            }
            for(int j = 0; j<p.GetBullets().size(); j++) {
                if(enemies.get(i).IsColliding(p.GetBullets().get(j).GetRect())) {
                    enemies.get(i).Die();
                    enemies.remove(i);
                    score++;

                    //break out of the loop so we don't get an indexOutOfBoundsException
                    break;
                }

            }
        }

        p.Update();
        for(int i = 0; i<enemies.size(); i++) {
            enemies.get(i).Update();
        }
    }
}
