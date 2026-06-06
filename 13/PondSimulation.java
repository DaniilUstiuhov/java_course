import java.util.ArrayList;
import java.util.List;

public class PondSimulation {
    static final int HEIGHT = 12;
    static final int WIDTH  = 22;
    static final int CYCLES = 30;

    public static void main(String[] args) {
        Stone[][] pond = new Stone[HEIGHT][WIDTH];

        // stone borders
        for (int i = 0; i < HEIGHT; i++) {
            pond[i][0]         = new Stone(i, 0);
            pond[i][WIDTH - 1] = new Stone(i, WIDTH - 1);
        }
        for (int j = 0; j < WIDTH; j++) {
            pond[0][j]          = new Stone(0, j);
            pond[HEIGHT - 1][j] = new Stone(HEIGHT - 1, j);
        }

        // initial weeds
        pond[3][5]  = new Weed(3, 5);
        pond[3][12] = new Weed(3, 12);
        pond[5][8]  = new Weed(5, 8);
        pond[6][16] = new Weed(6, 16);
        pond[8][4]  = new Weed(8, 4);
        pond[9][10] = new Weed(9, 10);
        pond[7][18] = new Weed(7, 18);
        pond[4][3]  = new Weed(4, 3);

        // initial fish
        pond[2][10] = new Fish(2, 10);
        pond[6][5]  = new Fish(6, 5);
        pond[9][17] = new Fish(9, 17);

        for (int cycle = 1; cycle <= CYCLES; cycle++) {
            System.out.println("\n=== Cycle " + cycle + " ===");

            // snapshot all current objects to avoid acting on newly created ones
            List<Stone> objects = new ArrayList<>();
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    if (pond[i][j] != null) objects.add(pond[i][j]);
                }
            }

            for (Stone obj : objects) {
                obj.act(pond);
            }

            printPond(pond);
            printStats(pond);
        }
    }

    static void printPond(Stone[][] pond) {
        for (Stone[] row : pond) {
            for (Stone cell : row) {
                if (cell == null)              System.out.print(".");
                else if (cell instanceof Fish) System.out.print("F");
                else if (cell instanceof Weed) System.out.print("W");
                else                           System.out.print("#");
            }
            System.out.println();
        }
    }

    static void printStats(Stone[][] pond) {
        int weeds = 0, fish = 0;
        for (Stone[] row : pond) {
            for (Stone cell : row) {
                if (cell instanceof Fish) fish++;
                else if (cell instanceof Weed) weeds++;
            }
        }
        System.out.println("Weeds: " + weeds + "  Fish: " + fish);
    }
}
