import com.raylib.Raylib.Vector2;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public abstract class Entity {

    protected Rectangle rect;

    public Entity(Vector2 pos,Vector2 dim,float speed,Color color) {
        this.rect = new Rectangle(pos, dim, speed, color);
    }

    public abstract void Update();

    public abstract void Draw();

    public void SetX(float x) {
        rect.GetPos().x(x);
    }

    public void SetY(float y) {
        rect.GetPos().y(y);
    }



    public Vector2 GetPos() {
        return rect.GetPos();
    }

    public Vector2 GetDim() {
        return rect.GetDim();
    }

    public float GetSpeed() {
        return rect.GetSpeed();
    }

    public Color GetColor() {
        return rect.GetColor();
    }

}
