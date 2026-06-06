public enum UsageType {
    BUSINESS(Color.BLUE, PointMarkers.CIRCLE),
    ENTERTAINMENT(Color.GREEN, PointMarkers.TRIANGLE),
    GOVERNMENT(Color.RED, PointMarkers.STAR),
    SPORTS(Color.ORANGE, PointMarkers.PUSH_PIN);

    private final Color color;
    private final PointMarkers marker;

    UsageType(Color color, PointMarkers marker) {
        this.color = color;
        this.marker = marker;
    }

    public String getMarkerString() {
        return color + " " + marker;
    }
}
