import com.raylib.Raylib.Vector2;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Enemy extends Entity {

    private Player p;
    public Enemy(Vector2 pos, Vector2 dim, float speed, Color color, Player p) {
        super(pos, dim, speed,color);
        this.p = p;
    }


    @Override
    public void Update() {
        if(GetPos().x() > GetScreenWidth() || GetPos().x()<0.0f) {
            GetPos().x(0.0f);

        }

        SetY(Utils.Lerp(GetPos().y(), p.GetPos().y(), .1f));
        SetX( Utils.Lerp(GetPos().x(), p.GetPos().x(), .1f) );



    }

    @Override
    public void Draw() {
        rect.Draw();
    }

}
