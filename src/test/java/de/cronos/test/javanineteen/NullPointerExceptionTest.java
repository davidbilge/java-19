package de.cronos.test.javanineteen;

import org.junit.jupiter.api.Test;

/**
 * Since Java 14
 * <a href="https://openjdk.org/jeps/358">JEP 358</a>
 */
class NullPointerExceptionTest {

    @Test
    void triggerNpe() {
        String firstName = "Max";
        String lastName = "Mustermann";
        String middleName = null;

        System.out.println(firstName.strip() + " " + middleName.strip() + " " + lastName.strip());
    }

}
