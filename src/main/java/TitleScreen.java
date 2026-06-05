import com.raylib.Raylib;

import static com.raylib.Colors.RED;
import static com.raylib.Colors.YELLOW;
import static com.raylib.Raylib.*;

public class TitleScreen extends Screen{
    private TextDrawable nameDraw;
    private Button playbutton;
    private Player p;
    private TextDrawable tooltip;
    public TitleScreen(int width, int height, Player p) {
        super(width, height);
        nameDraw = new TextDrawable(
                new Raylib.Vector2().x(width/2).y(height/8),
                "Space Game",
                Raylib.GetFontDefault(),
                50.0f,
                RED);
        playbutton = new Button((width/2),(height/2), "Play",20, (plyr->{
            Main.SetScreen(new MainGameScreen(width, height));
        }));
        Raylib.Vector2 posz = new Raylib.Vector2().x(nameDraw.GetPos().x()).y(nameDraw.GetPos().y() + (height/8));
        tooltip = new TextDrawable(posz,
                Main.GetRandomToolTip(),
                Raylib.GetFontDefault(),
                20.0f,
                YELLOW);
       this.p  = p;
    }

    @Override
    public void Draw() {
        BeginDrawing();
        nameDraw.Draw();
        playbutton.Draw();
        tooltip.Draw();
        EndDrawing();
    }

    @Override
    public void Update() {
        playbutton.Update(p);

    }
}
