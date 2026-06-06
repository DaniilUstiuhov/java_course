public class Park extends Point {
    private String name;

    public Park(String name, String location) {
        super(location);
        this.name = name;
    }

    @Override
    protected String getLabel() {
        return name + " National Park";
    }
}
