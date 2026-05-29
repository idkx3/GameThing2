import com.raylib.Raylib;
import static com.raylib.Colors.*;
import java.util.ArrayList;

public class ShootingEnemy extends Enemy{
    private ArrayList<Bullet> bullets;
    public ShootingEnemy(Raylib.Vector2 pos, Raylib.Vector2 dim, float speed, Raylib.Color color, Player p) {
        super(pos, dim, speed, color, p);
        bullets = new ArrayList<>();
    }

    @Override
    public void Update() {
        super.Update();
        float y  = GetPos().y();
        float x = GetPos().x();
        if(Utils.GetRandomInt(100) >= 99) {
            bullets.add(new Bullet(
                    new Raylib.Vector2().x(x).y(y+10.0f),
                    new Raylib.Vector2().x(20.0f).y(20.0f),
                    20.0f,
                    PURPLE,
                    true
            ));
        }
        for(Bullet b: bullets) {
            if(b.IsColliding(p.GetRect())) {
                p.DecHealth(1.0f);
            }
            b.Update();
        }

    }

    @Override
    public void Draw() {
        super.Draw();
        for(Bullet b: bullets) {
            b.Draw();
        }
    }
}
