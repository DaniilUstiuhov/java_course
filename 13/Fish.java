import java.util.ArrayList;
import java.util.List;

public class Fish extends Weed {
    private int hunger = 0;
    static final int MAX_HUNGER = 8;

    public Fish(int x, int y) {
        super(x, y);
    }

    @Override
    public void act(Stone[][] pond) {
        if (pond[x][y] != this) return;
        hunger++;
        // die of starvation
        if (hunger > MAX_HUNGER) {
            pond[x][y] = null;
            return;
        }
        // eat nearby weed if found
        if (eatWeed(pond)) return;
        // otherwise move to random empty cell
        move(pond);
    }

    private boolean eatWeed(Stone[][] pond) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                int nx = x + dx;
                int ny = y + dy;
                if (nx >= 0 && nx < pond.length && ny >= 0 && ny < pond[0].length) {
                    Stone cell = pond[nx][ny];
                    // eat only Weed, not Fish
                    if (cell instanceof Weed && !(cell instanceof Fish)) {
                        pond[nx][ny] = null;
                        pond[x][y] = null;
                        x = nx;
                        y = ny;
                        pond[x][y] = this;
                        hunger = 0;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void move(Stone[][] pond) {
        List<int[]> empty = getEmptyCells(pond);
        if (!empty.isEmpty()) {
            int[] cell = empty.get((int) (Math.random() * empty.size()));
            pond[x][y] = null;
            x = cell[0];
            y = cell[1];
            pond[x][y] = this;
        }
    }
}
