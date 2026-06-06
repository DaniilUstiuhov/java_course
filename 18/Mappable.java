public interface Mappable {
    void render();

    static double[] stringToLatLon(String location) {
        String[] parts = location.split(", ");
        return new double[]{Double.parseDouble(parts[0].trim()), Double.parseDouble(parts[1].trim())};
    }
}
