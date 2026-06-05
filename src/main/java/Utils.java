import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static Random rand = new Random();
    public static float Lerp(float a, float b, float t) {
        return a + t*(b-a);
    }

    public static int GetRandomInt(int max) {
        return GetRandomInt(0,max);
    }

    public static int GetRandomInt(int min,int max) {
        return ThreadLocalRandom.current().nextInt(min,max);
    }

    public static <T> T GetRandomElement(T[] arr) {
        return arr[rand.nextInt(arr.length)];
    }

    public static float GetRandomFloat(float max) {
        return GetRandomFloat(0.0f, max);
    }

    public static float GetRandomFloat(float min, float max) {
        return rand.nextFloat() * (max-min)+min;
    }
}
