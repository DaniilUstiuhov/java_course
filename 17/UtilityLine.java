public class UtilityLine implements Mappable {
    private final String name;
    private final UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public String getMarker() {
        return type.getMarkerString();
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() +
               ", \"name\": \"" + name + "\", \"utility\": \"" + type + "\"";
    }
}
