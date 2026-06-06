public record Place(String town, int distance) {
    @Override
    public String toString() {
        return town + " (" + distance + " km from Tallinn)";
    }
}
