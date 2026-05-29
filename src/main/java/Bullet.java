import com.raylib.Raylib;

import static com.raylib.Raylib.GetScreenHeight;
import static com.raylib.Raylib.GetScreenWidth;

public class Bullet extends Entity{
    private boolean neg;
    private BulletDir dir;
    public Bullet(Raylib.Vector2 pos, Raylib.Vector2 dim, float speed, Raylib.Color color,BulletDir dir) {
        super(pos, dim, speed, color);
        this.dir = dir;
    }

    @Override
    public void Update() {
        if(dir == BulletDir.DOWN) {
            this.GetPos().y(this.GetPos().y() + GetSpeed());
        } else if(dir == BulletDir.UP) {
            this.GetPos().y(this.GetPos().y()-GetSpeed());
        } else if(dir == BulletDir.LEFT) {
            this.GetPos().x(this.GetPos().x()+GetSpeed());
        } else if(dir == BulletDir.RIGHT) {
            this.GetPos().x(this.GetPos().x()-GetSpeed());
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
