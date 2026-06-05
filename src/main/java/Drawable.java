import com.raylib.Raylib;

public abstract class Drawable {
    protected Raylib.Vector2 pos;

    public Drawable(Raylib.Vector2 in) {
        this.pos = in;
    }

    public abstract void Draw();

    public abstract void Update();

}
