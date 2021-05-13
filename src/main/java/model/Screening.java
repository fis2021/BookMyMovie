package model;

import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.Id;

import java.util.Date;
import java.util.Objects;

public final class Screening {
    @Id
    private NitriteId id;
    private Date date;
    private String movieTitle;
    private int remainingCapacity;

    public Screening(NitriteId id, Date date, String movieTitle, int remainingCapacity) {
        this.id = id;
        this.date = date;
        this.movieTitle = movieTitle;
        this.remainingCapacity = remainingCapacity;
    }

    public Screening() {
    }

    public NitriteId getId() {
        return id;
    }

    public void setId(NitriteId id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    public void setRemainingCapacity(int remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Screening screening = (Screening) o;
        return Objects.equals(movieTitle, screening.movieTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieTitle);
    }
}