import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {
    private static final Random random = new Random();

    // static method: add random middle initial
    static String addMiddleInitial(String name) {
        return name + " " + (char)('A' + random.nextInt(26)) + ".";
    }

    // static method: reverse first name and add as last name
    static String addLastName(String name) {
        String first = name.split(" ")[0];
        return name + " " + new StringBuilder(first).reverse();
    }

    // applies each function to every element and prints after each
    static void applyTransformations(String[] names, List<UnaryOperator<String>> functions) {
        for (UnaryOperator<String> fn : functions) {
            for (int i = 0; i < names.length; i++) {
                names[i] = names[i].transform(fn);
            }
            System.out.println(Arrays.toString(names));
        }
    }

    public static void main(String[] args) {
        String[] names = {"Arvo", "Liisa", "Janis", "Liga", "Jonas", "Mindaugas", "Emma", "Nils"};

        String greeting = "What's up, ";

        List<UnaryOperator<String>> functions = new ArrayList<>();
        functions.add(String::toUpperCase);                          // instance method ref (arbitrary instance)
        functions.add(Main::addMiddleInitial);                       // static method ref
        functions.add(Main::addLastName);                            // static method ref
        functions.add(s -> s.replaceAll("(\\w)\\.", ".$1"));        // lambda: move period before initial
        functions.add(String::strip);                                // instance method ref (arbitrary instance)
        functions.add(greeting::concat);                             // instance method ref (specific instance)

        applyTransformations(names, functions);
    }
}
