package mr.cell.rabbitmqtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static mr.cell.rabbitmqtest.RabbitmqConfiguration.TOPIC_NAME;
import static mr.cell.rabbitmqtest.RabbitmqConfiguration.ROUTING_KEY;

@RequestMapping("/api")
@RestController
public class RabbitmqRestController {
    private static final Logger LOG = LoggerFactory.getLogger(RabbitmqRestController.class);

    private final RabbitTemplate rabbitTemplate;

    public RabbitmqRestController(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.CREATED)
    public void send(@RequestBody String message) {
        LOG.info("Sending message '{}'", message);
        rabbitTemplate.convertAndSend(
                TOPIC_NAME,
                ROUTING_KEY + ".rest",
                message);
    }
}
