package no.nav.bidrag.hendelse.producer
import org.apache.kafka.common.requests.ProduceRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
class KafkaController(@Autowired val producer: Producer){

    @PostMapping("/publish")
    fun sendMessageToKafkaTopic(@RequestParam("message") message: String){
        producer.sendMessage(message);
    }

}
