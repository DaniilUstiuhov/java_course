import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Layer<T extends Mappable> {
    private List<T> layerElements;

    public Layer(T[] elements) {
        this.layerElements = new ArrayList<>(Arrays.asList(elements));
    }

    public void addElement(T element) {
        layerElements.add(element);
    }

    @SafeVarargs
    public final void addElements(T... elements) {
        layerElements.addAll(Arrays.asList(elements));
    }

    public void renderLayer() {
        for (T element : layerElements) {
            element.render();
        }
    }
}
