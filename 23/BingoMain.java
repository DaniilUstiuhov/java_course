import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BingoMain {
    public static void main(String[] args) {
        // B: 1-15 — IntStream.rangeClosed
        Stream<String> bStream = IntStream.rangeClosed(1, 15)
                .mapToObj(n -> "B" + n);

        // I: 16-30 — Stream.iterate with predicate (Java 9+)
        Stream<String> iStream = Stream.iterate(16, n -> n <= 30, n -> n + 1)
                .map(n -> "I" + n);

        // N: 31-45 — Arrays.stream on a programmatically filled array
        int[] nNums = new int[15];
        Arrays.setAll(nNums, i -> 31 + i);
        Stream<String> nStream = Arrays.stream(nNums)
                .mapToObj(n -> "N" + n);

        // G: 46-60 — Collection.stream()
        List<Integer> gList = new ArrayList<>();
        for (int i = 46; i <= 60; i++) gList.add(i);
        Stream<String> gStream = gList.stream()
                .map(n -> "G" + n);

        // O: 61-75 — Stream.generate with AtomicInteger counter
        AtomicInteger counter = new AtomicInteger(61);
        Stream<String> oStream = Stream.generate(() -> "O" + counter.getAndIncrement())
                .limit(15);

        // concatenate all five streams and print each label
        Stream.concat(
                Stream.concat(
                        Stream.concat(
                                Stream.concat(bStream, iStream),
                                nStream),
                        gStream),
                oStream)
                .forEach(System.out::println);
    }
}
