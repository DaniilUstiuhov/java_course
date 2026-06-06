public class LayerMain {
    public static void main(String[] args) {
        Park[] nationalParks = new Park[]{
            new Park("Pirita jõeoru MKA", "59.470554, 24.865137"),
            new Park("Mäealuse MKA", "59.519737, 24.872467"),
            new Park("Krillimäe MKA", "59.538170, 24.820246"),
            new Park("Leidissoo LKA", "59.129381, 23.713533"),
        };

        Layer<Park> parkLayer = new Layer<>(nationalParks);
        parkLayer.renderLayer();

        River[] rivers = new River[]{
            new River("Pirita jõgi", "59.465427, 24.832956",
                                      "59.466783, 24.873256",
                                      "59.458080, 24.899915"),
            new River("Keila jõgi", "59.403227, 24.280680",
                                     "59.384197, 24.314466",
                                     "59.367600, 24.350924")
        };

        Layer<River> riverLayer = new Layer<>(rivers);
        riverLayer.addElements(
            new River("Pärnu jõgi", "58.387391, 24.484892",
                                     "58.499331, 24.866929",
                                     "58.581174, 25.007622"),
            new River("Narva jõgi", "59.462094, 28.056027",
                                     "59.382011, 28.209953",
                                     "59.354455, 28.192309")
        );
        riverLayer.renderLayer();
    }
}
