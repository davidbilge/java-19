package de.cronos.test.javanineteen.records;

import java.util.Objects;
import lombok.Builder;

/**
 * Since Java 16
 * <a href="https://openjdk.org/jeps/395">JEP 395</a>
 */
@Builder
public record User(String firstName, String middleName, String lastName) {
    // compact constructor
    public User {
        Objects.requireNonNull(lastName);
    }

    public String getConcatenatedNames() {
        return String.join(" ", firstName, middleName, lastName);
    }
}
