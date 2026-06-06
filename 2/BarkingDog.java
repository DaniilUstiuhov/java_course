public class BarkingDog {
    public static void main(String[] args) {
        System.out.println(shouldWakeUp(true, 7));
        System.out.println(shouldWakeUp(true, 12));
        System.out.println(shouldWakeUp(false, 7));
        System.out.println(shouldWakeUp(true, 23));
    }

    static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        if (hourOfDay < 0 || hourOfDay > 23) return false;
        return barking && (hourOfDay < 8 || hourOfDay > 22);
    }
}
