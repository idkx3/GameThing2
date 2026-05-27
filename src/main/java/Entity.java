import com.raylib.Raylib.Vector2;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public abstract class Entity {

    private Rectangle rect;

    public Entity(Vector2 pos,Vector2 dim,float speed,Color color) {
        this.rect = new Rectangle(pos, dim, speed, color);
    }

    public abstract void Update();

    public abstract void Draw();

    public Rectangle GetRect() {
        return rect;
    }

    public void SetX(float x) {
        rect.GetPos().x(x);
    }

    public void SetY(float y) {
        rect.GetPos().y(y);
    }

    public void SetColor(Color c) {
        rect.setColor(c);
    }

    public Rectangle getRect() {
        return rect;
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

    public boolean IsColliding(Rectangle other) {
        return rect.IsColliding(other);
    }

}