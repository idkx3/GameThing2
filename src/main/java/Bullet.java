import com.raylib.Raylib;

import static com.raylib.Raylib.GetScreenHeight;
import static com.raylib.Raylib.GetScreenWidth;

public class Bullet extends Entity{
    private boolean neg;
    public Bullet(Raylib.Vector2 pos, Raylib.Vector2 dim, float speed, Raylib.Color color,boolean neg) {
        super(pos, dim, speed, color);
        this.neg = neg;
    }

    @Override
    public void Update() {
        if(neg) {
            this.GetPos().y(this.GetPos().y() - GetSpeed());
        } else {
            this.GetPos().y(this.GetPos().y()+GetSpeed());
        }
    }

    public boolean IsOffscreen() {
        return GetPos().x() > GetScreenWidth() || GetPos().x() < 0
                || GetPos().y() > GetScreenHeight()|| GetPos().y()<0 ;
    }

    @Override
    public void Draw() {
        GetRect().Draw();
    }
}
