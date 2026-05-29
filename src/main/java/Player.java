import com.raylib.Raylib.Vector2;

import java.util.ArrayList;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Player extends Entity{

    private ArrayList<Bullet> bullets;
    private float health;
    private int money;
    public Player(Vector2 pos,Vector2 dim,float speed,Color color) {
        super(pos, dim, speed,color);
        bullets = new ArrayList<>();
        health = 100.0f;
        money = 0;
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
            Shoot(true);
        } else if(IsKeyDown(KEY_LEFT_SHIFT)) {
            Shoot(false);
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
        DrawRectangleV(new Vector2().x(0.0f).y(0.0f),
                new Vector2().x(health).y(10.0f), GREEN);
    }

    public void DecHealth(float am) {
        health-=am;
        System.out.println(health);
    }


    public float getHealth() {
        return health;
    }

    public void AddMoney(int am) {
        money += am;
    }

    public void SetMoney(int am) {
        money = am;
    }

    public int GetMoney() {
        return money;
    }

    public ArrayList<Bullet> GetBullets() {
        return bullets;
    }

    private void Shoot(boolean neg) {
        Vector2 bulletPos = new Vector2().x(GetPos().x()).y(GetPos().y()-20.0f);

        bullets.add(new Bullet(bulletPos, GetDim(), GetSpeed(), YELLOW,neg));
    }


}
