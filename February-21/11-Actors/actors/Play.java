package actors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Play extends Production {
    private String playwrightName;

    public Play(String name, LocalDate releaseDate, String playwrightName) {
        super(name, releaseDate);
        this.playwrightName = playwrightName;
    }

    @Override
    public String toString() {
        return String.format("Пиеса %s, написана от %s е излязла на %s г.",
                this.getName(),
                this.playwrightName,
                this.getReleaseDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }
}
