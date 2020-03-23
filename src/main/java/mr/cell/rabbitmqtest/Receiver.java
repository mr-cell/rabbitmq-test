package mr.cell.rabbitmqtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    public void receiveMessage(String message) {
        LOG.info("Received message: '{}'", message);
    }
}
