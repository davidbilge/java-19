package de.cronos.test.javanineteen.records;

/**
 * Since Java 16
 * <a href="https://openjdk.org/jeps/395">JEP 395</a>
 */
public record User(String firstName, String middleName, String lastName) {
    public String getConcatenatedNames() {
        return String.join(" ", firstName, middleName, lastName);
    }
}
