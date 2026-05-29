import com.raylib.Raylib.Vector2;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Enemy extends Entity {

    protected Player p;
    public Enemy(Vector2 pos, Vector2 dim, float speed, Color color, Player p) {
        super(pos, dim, speed,color);
        this.p = p;
    }


    @Override
    public void Update() {
        if(GetPos().x() > GetScreenWidth() || GetPos().x()<0.0f) {
            GetPos().x(0.0f);

        }





    }

    @Override
    public void Draw() {
        GetRect().Draw();
    }

}
