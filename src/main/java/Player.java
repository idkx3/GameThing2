import com.raylib.Raylib.Vector2;

import java.util.ArrayList;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Player extends Entity{

    private ArrayList<Bullet> bullets;

    public Player(Vector2 pos,Vector2 dim,float speed,Color color) {
        super(pos, dim, speed,color);
        bullets = new ArrayList<>();
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
       for(int i = bullets.size()-1; i>=0; i--) {
           if(bullets.get(i).IsOffscreen()) {
               bullets.remove(bullets.get(i));
               System.out.println("Removing");

           } else {
               bullets.get(i).Update();
           }
       }
    }
    @Override
    public void Draw() {
        for(Bullet b: bullets) {
            b.Draw();
        }
        GetRect().Draw();

    }


    public ArrayList<Bullet> GetBullets() {
        return bullets;
    }

    private void Shoot() {
        Vector2 bulletPos = new Vector2().x(GetPos().x()).y(GetPos().y()-20.0f);

        bullets.add(new Bullet(bulletPos, GetDim(), GetSpeed(), YELLOW));
    }


}
