public enum UtilityType {
    ELECTRICAL(Color.BLACK, LineMarkers.DASHED),
    FIBER_OPTIC(Color.GREEN, LineMarkers.DOTTED),
    WATER(Color.BLUE, LineMarkers.SOLID);

    private final Color color;
    private final LineMarkers marker;

    UtilityType(Color color, LineMarkers marker) {
        this.color = color;
        this.marker = marker;
    }

    public String getMarkerString() {
        return color + " " + marker;
    }
}
