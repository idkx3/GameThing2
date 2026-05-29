import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class GameOverScreen extends Screen {
    private int score;
    public GameOverScreen(int width, int height,int score) {
        super(width, height);
        this.score = score;
    }

    @Override
    public void Draw() {
        BeginDrawing();
        ClearBackground(BLACK);
        DrawText("GAME OVER!", width/2, height/2, 20, RED);
        DrawText("Final Score: " + String.valueOf(score), width/2, height/3, 20, RED);
        EndDrawing();
        //System.out.println("hello");
    }

    @Override
    public void Update() {

    }


}
