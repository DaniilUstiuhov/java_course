public class Weed extends Stone {
    private boolean alive;
    private int size;

    public Weed(int x, int y) {
        super(x, y);
        this.alive = true;
        this.size = 1;
    }

    public void grow() {
        if (alive) size++;
    }

    public void die() {
        alive = false;
    }

    public boolean isAlive() { return alive; }
    public int getSize() { return size; }

    @Override
    public String toString() {
        return "Weed at (" + x + "," + y + ") size=" + size + " alive=" + alive;
    }
}
