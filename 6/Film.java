public class Film {
    private String title;
    private String director;
    private String producer;
    private String releaseDate;
    private String runningTime;
    private String description;

    public Film(String title, String director, String producer,
                String releaseDate, String runningTime, String description) {
        this.title = title;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.runningTime = runningTime;
        this.description = description;
    }

    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public String getProducer() { return producer; }
    public String getReleaseDate() { return releaseDate; }
    public String getRunningTime() { return runningTime; }
    public String getDescription() { return description; }
}
