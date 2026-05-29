
import java.util.ArrayList;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Main {
    private static Screen currentScreen;
    public static void main(String[] args) {


        InitWindow(1920, 600, "Demo");
        SetTargetFPS(60);


        currentScreen = new MainGameScreen(GetScreenWidth(),GetScreenHeight());

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


}