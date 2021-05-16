package model;

import org.dizitart.no2.objects.Id;
import java.util.Objects;

public class Movie{
    @Id
    private String name;
    private String genre;
    private String description;
    private static int contor=1;
    private String rating="";
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
        ratings[contor-1]=r;
        contor++;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        int s=0;
        int r=0;
        for (int i=1; i<contor; i++){
            s = s + ratings[i-1];
        }
        r= s/contor;
             return rating+r;
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

}
