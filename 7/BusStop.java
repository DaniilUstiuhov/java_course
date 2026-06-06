public record BusStop(String id, String name, double latitude, double longitude, String area) {

    // Haversine formula to calculate distance in km between two stops
    public static double getDistance(BusStop stop1, BusStop stop2) {
        final double R = 6371.0;
        double lat1 = Math.toRadians(stop1.latitude());
        double lat2 = Math.toRadians(stop2.latitude());
        double deltaLat = Math.toRadians(stop2.latitude() - stop1.latitude());
        double deltaLon = Math.toRadians(stop2.longitude() - stop1.longitude());

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    public static boolean isSameArea(BusStop stop1, BusStop stop2) {
        return stop1.area().equals(stop2.area());
    }
}
