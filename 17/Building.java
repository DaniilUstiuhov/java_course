public class Building implements Mappable {
    private final String name;
    private final UsageType type;

    public Building(String name, UsageType type) {
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
        return Geometry.POINT;
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() +
               ", \"name\": \"" + name + "\", \"usage\": \"" + type + "\"";
    }
}
