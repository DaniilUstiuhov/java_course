import java.util.Arrays;

public abstract class Line implements Mappable {
    private double[][] locations;

    public Line(String... locationStrs) {
        this.locations = new double[locationStrs.length][];
        for (int i = 0; i < locationStrs.length; i++) {
            this.locations[i] = Mappable.stringToLatLon(locationStrs[i]);
        }
    }

    private String locations() {
        return Arrays.deepToString(locations);
    }

    @Override
    public void render() {
        System.out.println("Render " + getLabel() + " as LINE (" + locations() + ")");
    }

    protected abstract String getLabel();
}
