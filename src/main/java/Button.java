import com.raylib.Raylib;

import java.util.function.Consumer;

import static com.raylib.Colors.RED;
import static com.raylib.Colors.WHITE;
import static com.raylib.Raylib.*;

public class Button {

    private String msg;
    int size;
    private int fntSize;
    private Rectangle hitbox;
    private Consumer<Player> con;
    public Button(int x, int y, String msg, int fntSize, Consumer<Player> p) {

        this.msg = msg;
        this.fntSize = fntSize;
        this.size = MeasureText(msg, fntSize);
        this.hitbox = new Rectangle(
                new Raylib.Vector2().x(x).y(y),
                new Raylib.Vector2().x(this.size).y(fntSize),
                RED);
        this.con = p;
    }

    public void Draw() {
        DrawText(msg, (int)hitbox.GetPos().x(), (int)hitbox.GetPos().y(),fntSize,WHITE);

    }

    public void Update(Player p) {
        if(IsClicked()) {
            con.accept(p);
        }
    }

    public boolean IsClicked() {
        return hitbox.IsColliding(GetMousePosition()) && IsMouseButtonDown(MOUSE_BUTTON_LEFT);
    }
}
