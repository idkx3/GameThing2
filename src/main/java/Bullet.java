import com.raylib.Raylib;

import static com.raylib.Raylib.GetScreenHeight;
import static com.raylib.Raylib.GetScreenWidth;

public class Bullet extends Entity{
    public Bullet(Raylib.Vector2 pos, Raylib.Vector2 dim, float speed, Raylib.Color color) {
        super(pos, dim, speed, color);
    }

    @Override
    public void Update() {
        this.GetPos().y(this.GetPos().y()+GetSpeed());
    }

    public boolean IsOffscreen() {
        return GetPos().x() > GetScreenWidth()
                || GetPos().y() > GetScreenHeight() ;
    }

    @Override
    public void Draw() {
        GetRect().Draw();
    }
}
