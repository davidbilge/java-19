package de.cronos.test.javanineteen;

import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Since Java 16
 * <a href="https://openjdk.org/jeps/394">JEP 394</a>
 */
@SuppressWarnings("ConstantConditions")
@Slf4j
class InstanceofPatternMatchingTest {

    @Test
    void oldStyle() {
        Number number = 1337;

        if (number instanceof Integer) {
            Integer i = (Integer) number;
            log.info("Number is an integer: {}", i);
        } else if (number instanceof BigDecimal bd) {
            log.info("Number is a big decimal: {}", bd.add(BigDecimal.ONE));
        }
    }

    @Test
    void simplePatternMatching() {
        Number number = 1337;

        if (number instanceof Integer i) {
            log.info("Number is an integer: {}", i);
        } else if (number instanceof BigDecimal bd) {
            log.info("Number is a big decimal: {}", bd.add(BigDecimal.ONE));
        }
    }

    @Test
    void extendedPatternMatching() {
        Number number = 1337;

        if (number instanceof BigDecimal bd && bd.subtract(BigDecimal.ONE).compareTo(BigDecimal.valueOf(1336)) == 0) {
            log.info("Number is 1337: {}", bd);
        } else if (number instanceof BigDecimal bd && bd.compareTo(BigDecimal.ONE) > 0) {
            log.info("Number is a big decimal and greater than one");
        }
    }

    @Test
    void invertedPatternMatching() {
        Number number = 1337;

        if (!(number instanceof BigDecimal bd)) {
            log.info("Number is not a big decimal");
        } else {
            log.info("Number is a big decimal {}", bd);
        }
    }

    @Test
    void flowScope() {
        Number number = 1337;

        if (!(number instanceof BigDecimal bd)) {
            throw new IllegalArgumentException("Number needs to be a BigDecimal");
        }

        log.info("Number is a big decimal {}", bd);
    }
}
