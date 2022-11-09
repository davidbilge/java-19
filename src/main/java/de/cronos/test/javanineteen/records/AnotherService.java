package de.cronos.test.javanineteen.records;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AnotherService {
    public void log() {
        log.info("Test");
    }
}
