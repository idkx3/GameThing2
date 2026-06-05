import com.raylib.Raylib;

import static com.raylib.Raylib.DrawTextEx;

public class TextDrawable extends Drawable{
    private final Raylib.Font f;
    private final String msg;
    private final float size;
    private final Raylib.Color c;
    public TextDrawable(Raylib.Vector2 in,String msg, Raylib.Font f,float size,Raylib.Color c) {
        super(in);
        this.f = f;
        this.msg = msg;
        this.size = size;
        this.c = c;
    }

    @Override
    public void Draw() {
        DrawTextEx(f, msg, pos, size, 1, c);
    }

    public Raylib.Vector2 GetPos() {
        return pos;
    }

    @Override
    public void Update() {

    }
}
