import java.util.ArrayList;
import java.util.List;

public class Weed extends Stone {
    private int age = 0;
    static final int MAX_AGE = 30;
    static final double SPREAD_CHANCE = 0.2;

    public Weed(int x, int y) {
        super(x, y);
    }

    public boolean isDead() { return age > MAX_AGE; }

    @Override
    public void act(Stone[][] pond) {
        if (pond[x][y] != this) return;
        age++;
        if (isDead()) {
            pond[x][y] = null;
            return;
        }
        if (Math.random() < SPREAD_CHANCE) {
            spread(pond);
        }
    }

    private void spread(Stone[][] pond) {
        List<int[]> empty = getEmptyCells(pond);
        if (!empty.isEmpty()) {
            int[] cell = empty.get((int) (Math.random() * empty.size()));
            pond[cell[0]][cell[1]] = new Weed(cell[0], cell[1]);
        }
    }

    protected List<int[]> getEmptyCells(Stone[][] pond) {
        List<int[]> cells = new ArrayList<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                int nx = x + dx;
                int ny = y + dy;
                if (nx >= 0 && nx < pond.length && ny >= 0 && ny < pond[0].length && pond[nx][ny] == null) {
                    cells.add(new int[]{nx, ny});
                }
            }
        }
        return cells;
    }
}
