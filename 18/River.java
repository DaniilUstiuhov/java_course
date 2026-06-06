public class River extends Line {
    private String name;

    public River(String name, String... locations) {
        super(locations);
        this.name = name;
    }

    @Override
    protected String getLabel() {
        return name + " River";
    }
}
