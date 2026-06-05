
import com.raylib.Raylib;

import java.util.ArrayList;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Main {
    private static Screen currentScreen;
    private static Player p;
    private  final static String[] tooltips = {"It's a game!","Something","60!"};
    public static void main(String[] args) {


        InitWindow(800, 450, "Demo");
        SetTargetFPS(60);
        Raylib.Vector2 pos = new Raylib.Vector2();
        pos.x(GetScreenWidth()/2);
        pos.y(GetScreenHeight()/2);
        p = new Player(pos, new Raylib.Vector2().x(20.0f).y(20.0f), 100.0f,ORANGE);

        currentScreen = new TitleScreen(GetScreenWidth(),GetScreenHeight(), p);

        while (!WindowShouldClose()) {
            if(IsWindowResized()) {
                currentScreen.Refresh(GetScreenWidth(), GetScreenHeight());
            }

           currentScreen.Update();

           currentScreen.Draw();

        }
        CloseWindow();
    }


    public static void SetScreen(Screen s) {
        currentScreen = s;

    }

    public static String[] GetToolTips() {
        return tooltips;
    }

    public static String GetRandomToolTip() {
        return Utils.GetRandomElement(tooltips);
    }


}