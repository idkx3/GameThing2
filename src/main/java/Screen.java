public abstract class Screen {
    protected int width;
    protected int height;
    public Screen(int width,int height) {
        this.width = width;
        this.height = height;
    }
    public void Refresh(int newWidth,int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }
    public abstract void Draw();
    public abstract void Update();
}
