public class Film {

    private int id;
    private String title;
    private Date releaseDate;
    private String country;

    public Film(int id, String title, Date releaseDate, String country) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getCountry() {
        return country;
    }

    @Override    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", country='" + country + '\'' +
                '}';
    }
}