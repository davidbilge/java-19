package de.cronos.test.javanineteen.records;

import org.springframework.stereotype.Component;

/**
 * A record can also become a Spring bean. Constructor injection of other beans from the Application Context is also supported.
 * <p>
 * Note that you generally should not do this.
 */
@Component
public record ServiceRecord(AnotherService anotherService) {
    void log() {
        anotherService.log();
    }
}
