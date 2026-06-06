import java.util.List;

public class Fish extends Weed {
    private String name;

    public Fish(int x, int y, String name) {
        super(x, y);
        this.name = name;
    }

    // move to new position if not blocked by a stone or weed
    public boolean move(int newX, int newY, List<Stone> pondObjects) {
        for (Stone obj : pondObjects) {
            if (obj != this && obj.getX() == newX && obj.getY() == newY) {
                return false;
            }
        }
        this.x = newX;
        this.y = newY;
        return true;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "Fish '" + name + "' at (" + x + "," + y + ")";
    }
}
