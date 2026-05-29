import static com.raylib.Colors.BLACK;
import static com.raylib.Colors.GREEN;
import static com.raylib.Raylib.*;

public class ShopScreen extends Screen{
    private Player p;
    public ShopScreen(int width, int height,Player p) {
        super(width, height);
        this.p = p;
    }

    @Override
    public void Draw() {
        BeginDrawing();
        ClearBackground(BLACK);
        DrawText("You have " + p.GetMoney() + " dollar(s)", width/2, height/2, 20, GREEN);
        EndDrawing();
    }

    @Override
    public void Update() {

    }
}
