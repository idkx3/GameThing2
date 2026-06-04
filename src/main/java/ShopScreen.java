import static com.raylib.Colors.BLACK;
import static com.raylib.Colors.GREEN;
import static com.raylib.Raylib.*;

public class ShopScreen extends Screen{
    private Player p;
    private int textX;
    private int textY;
    private Button b;
    private Button exitButton;
    public ShopScreen(int width, int height,Player p) {
        super(width, height);
        this.p = p;
        int size = MeasureText("You have " + p.GetMoney() + " dollar(s)", 20);
        textX = (width/2)-(size/2);
        textY = (height/2)-(size/2);
        b = new Button(textX, (height/2)-(size/3), "Power Up", 20, (
                plyr->{
                    if(plyr.GetMoney()>0) {
                        plyr.AddMoney(-10);
                        plyr.SetPowerUp(new HealthRegenPowerUp());
                    }

                }));
        exitButton = new Button(textX, (height/2)-(size/4), "Exit", 20,
                (player -> {
                    Main.SetScreen(new MainGameScreen(width,height, this.p));
                }));
    }

    @Override
    public void Draw() {
        BeginDrawing();
        ClearBackground(BLACK);
        DrawText("You have " + p.GetMoney() + " dollar(s)", textX, textY, 20, GREEN);
        b.Draw();
        exitButton.Draw();
        EndDrawing();
    }

    @Override
    public void Update() {
        b.Update(p);exitButton.Update(p);
    }
}
