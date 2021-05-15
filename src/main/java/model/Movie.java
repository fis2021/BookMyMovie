package model;

import org.dizitart.no2.objects.Id;
import java.util.Objects;

public class Movie{
    @Id
    private String name;
    private String genre;
    private String description;
    private static int contor=0;
    private int[] ratings = new int[20];

    public Movie(String name, String genre, String description) {
        this.name = name;
        this.genre = genre;
        this.description = description;
    }

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setRate(int r) {
        ratings[contor]=r;
        contor++;
    }

    public int getContor() {
        return contor;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int[] getRatings() {
        return ratings;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    /*@Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }*/
}
