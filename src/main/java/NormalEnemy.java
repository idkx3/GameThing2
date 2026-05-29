import com.raylib.Raylib;

public class NormalEnemy extends Enemy{
    public NormalEnemy(Raylib.Vector2 pos, Raylib.Vector2 dim, float speed, Raylib.Color color, Player p) {
        super(pos, dim, speed, color, p);
    }

    @Override
    public void Update() {
        super.Update();
        SetY(Utils.Lerp(GetPos().y(), p.GetPos().y(), GetSpeed()));
        SetX( Utils.Lerp(GetPos().x(), p.GetPos().x(), GetSpeed()) );
    }
}
