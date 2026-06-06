public class Stone {
    protected int x;
    protected int y;

    public Stone(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public String toString() {
        return "Stone at (" + x + "," + y + ")";
    }
}
