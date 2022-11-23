package de.cronos.test.javanineteen;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Since Java 14
 * <a href="https://openjdk.org/jeps/361">JEP 361</a>
 */
@Slf4j
class SwitchTest {

    private enum Status {
        NEW, IN_PROGRESS, FINISHED
    }

    @ParameterizedTest
    @EnumSource
    void oldSwitchSyntax(Status status) {
        String text;

        switch (status) {
            case NEW:
                text = "new";
                break;
            case IN_PROGRESS:
                text = "in progress";
                break;
            case FINISHED:
                text = "finished";
                break;
            default:
                throw new IllegalArgumentException("Unknown status " + status);
        }

        log.info("Operation is {}", text);
    }

    @ParameterizedTest
    @EnumSource
    void newSwitchSyntax(Status status) {
        String text;

        switch (status) {
            case NEW -> text = "new";
            case IN_PROGRESS -> text = "in progress";
            case FINISHED -> text = "finished";
            default -> throw new IllegalArgumentException("Unknown status " + status);
        }

        log.info("Operation is {}", text);
    }

    @ParameterizedTest
    @EnumSource
    void switchExpressionNewSyntax(Status status) {
        String text = switch (status) {
            case NEW -> "new";
            case IN_PROGRESS -> {
                log.debug("We are still in progress");
                yield "in progress";
            }
            case FINISHED -> "finished";
            // default branch can be removed (and IntelliJ IDEA shows an according warning)
            default -> throw new IllegalArgumentException("Unknown status " + status);
        };

        log.info("Operation is {}", text);
    }

    @ParameterizedTest
    @EnumSource
    void switchExpressionColonSyntax(Status status) {
        String text = switch (status) {
            case NEW:
                yield "new";
            case IN_PROGRESS: {
                log.debug("We are still in progress");
                yield "in progress";
            }
            case FINISHED:
                yield "finished";
        };

        log.info("Operation is {}", text);
    }
}
