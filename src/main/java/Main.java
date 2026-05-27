
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
        Player p = new Player(pos, dim, 10.0f,RED);
        Enemy e = new Enemy(new Vector2().x((float)Math.random()*100.0f).y((float)Math.random()*100.0f), dim, 20.0f, BLUE, p);
        while (!WindowShouldClose()) {

            p.Update();
            e.Update();
            BeginDrawing();
            ClearBackground(BLACK);
            p.Draw();
            e.Draw();
            EndDrawing();

        }
        CloseWindow();
    }
}