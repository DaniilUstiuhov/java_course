public class Stone {
    protected int x;
    protected int y;

    public Stone(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // stones do nothing each cycle
    public void act(Stone[][] pond) {}
}
