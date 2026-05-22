import com.raylib.Raylib.Vector2;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Rectangle {
    private Vector2 pos;
    private Vector2 dim;
    private float speed;
    private Color color;
    public Rectangle(Vector2 pos, Vector2 dim, float speed,Color color) {
        this.pos = pos;
        this.dim = dim;
        this.speed = speed;
        this.color = color;
    }

    public void Draw() {
        DrawRectangleV(pos, dim, color);
    }

    public Vector2 GetPos() {
        return pos;
    }

    public Vector2 GetDim() {
        return dim;
    }

    public float GetSpeed() {
        return speed;
    }

    public Color GetColor() {
        return color;
    }

}
