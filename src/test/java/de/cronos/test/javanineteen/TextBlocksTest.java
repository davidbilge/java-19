package de.cronos.test.javanineteen;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Since Java 15
 * <a href="https://openjdk.org/jeps/378">JEP 378</a>
 */
@Slf4j
class TextBlocksTest {
    @Test
    void textblocks() {
        String json = """
            {
                "firstName": "Max",
                "middleName": null,
                "lastName": "Mustermann"
            }
            """;

        assertThat(json).startsWith("{");

        log.info("JSON: \n{}", json);
    }

    @Test
    void textblocksWithLongLines() {
        String veryLongLine = """
            Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore \
            magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea \
            commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \
            Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\
            """;

        assertThat(veryLongLine).doesNotContain("\n");

        log.info(veryLongLine);
    }

}
