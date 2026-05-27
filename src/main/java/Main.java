
import java.util.ArrayList;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Main {
    public static void main(String args[]) {
        String appHomeDir = System.getenv("APP_HOME");
        System.out.println(appHomeDir);
        InitWindow(800, 450, "Demo");
        SetTargetFPS(60);
        Vector2 pos = new Vector2();
        pos.x(100.0f);
        pos.y(100.0f);
        Vector2 dim = new Vector2();
        dim.x(20.0f);
        dim.y(20.0f);
        Player p = new Player(pos, dim, 10.0f,ORANGE);
        ArrayList<Enemy> enemies = new ArrayList<>();
        for(int i = 0; i<Utils.GetRandomInt(100); i++) {
            float ranx = Utils.GetRandomFloat(0.0f, GetScreenWidth());
            float randy = Utils.GetRandomFloat(0.0f, GetScreenHeight());
            enemies.add(new Enemy(new Vector2().x(ranx).y(randy), dim, Utils.GetRandomFloat(0.05f), BLUE, p));
        }
        System.out.println(enemies.size());
        while (!WindowShouldClose()) {
           for(int i = enemies.size()-1; i>=0; i--) {
               for(int j = 0; j<p.GetBullets().size(); j++) {
                   if(enemies.get(i).IsColliding(p.GetBullets().get(j).GetRect())) {
                       enemies.remove(i);
                       //break out of the loop so we don't get an indexOutOfBoundsException
                       break;
                   }
               }
           }
            p.Update();
            for(int i = 0; i<enemies.size(); i++) {
                enemies.get(i).Update();
            }
            BeginDrawing();
            ClearBackground(BLACK);
            p.Draw();
            for(Enemy e: enemies) {
                e.Draw();
            }

            EndDrawing();

        }
        CloseWindow();
    }
}