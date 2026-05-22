import com.raylib.Raylib.Vector2;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Player extends Entity{

    private Rectangle bullet;

    public Player(Vector2 pos,Vector2 dim,float speed,Color color) {
        super(pos, dim, speed,color);

    }
    @Override
    public void Update() {
        if(IsKeyDown(KEY_UP)) {
            SetY(GetPos().y()-GetSpeed());
        } else if(IsKeyDown(KEY_DOWN)) {
            SetY(GetPos().y()+GetSpeed());
        } else if(IsKeyDown(KEY_RIGHT)) {
            SetX(GetPos().x()+GetSpeed());
        } else if(IsKeyDown(KEY_LEFT)) {
            SetX(GetPos().x()-GetSpeed());
        } else if(IsKeyDown(KEY_SPACE)) {
            Shoot();
        }
    }
    @Override
    public void Draw() {
        if(bullet != null) {
            bullet.Draw();
        }
        rect.Draw();

    }


    private void Shoot() {
        Vector2 bulletPos = new Vector2().x(GetPos().x()).y(GetPos().y()-20.0f);
        bullet = new Rectangle(bulletPos,GetDim(), GetSpeed(),YELLOW );
    }



}
