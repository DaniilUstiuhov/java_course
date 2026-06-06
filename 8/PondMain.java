import java.util.ArrayList;
import java.util.List;

public class PondMain {
    public static void main(String[] args) {
        List<Stone> pond = new ArrayList<>();

        pond.add(new Stone(2, 3));
        pond.add(new Stone(5, 5));

        Weed weed1 = new Weed(1, 1);
        Weed weed2 = new Weed(3, 4);
        pond.add(weed1);
        pond.add(weed2);

        Fish fish1 = new Fish(0, 0, "Nemo");
        Fish fish2 = new Fish(4, 2, "Dory");
        pond.add(fish1);
        pond.add(fish2);

        // lifecycle loop
        for (int cycle = 1; cycle <= 4; cycle++) {
            System.out.println("\n--- Cycle " + cycle + " ---");

            for (Stone obj : pond) {
                if (obj instanceof Fish fish) {
                    int newX = fish.getX() + (int)(Math.random() * 3) - 1;
                    int newY = fish.getY() + (int)(Math.random() * 3) - 1;
                    boolean moved = fish.move(newX, newY, pond);
                    System.out.println(fish + (moved ? " moved" : " blocked"));
                } else if (obj instanceof Weed weed) {
                    // weed dies after size 4
                    if (weed.getSize() >= 4) {
                        weed.die();
                    } else {
                        weed.grow();
                    }
                    System.out.println(weed);
                } else {
                    System.out.println(obj);
                }
            }
        }
    }
}
