package actors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Movie extends Production {
    private double imdbRating;

    public Movie(String name, LocalDate releaseDate, double imdbRating) {
        super(name, releaseDate);
        this.imdbRating = imdbRating;
    }

    @Override
    public String toString() {
        return String.format("Филм %s, излязъл на %s г. има рейтинг от %.1f звезди в IMDB.",
                this.getName(),
                this.getReleaseDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                this.imdbRating);
    }
}
