import java.util.Arrays;

public abstract class Point implements Mappable {
    private double[] location;

    public Point(String locationStr) {
        this.location = Mappable.stringToLatLon(locationStr);
    }

    private String location() {
        return Arrays.toString(location);
    }

    @Override
    public void render() {
        System.out.println("Render " + getLabel() + " as POINT (" + location() + ")");
    }

    protected abstract String getLabel();
}
