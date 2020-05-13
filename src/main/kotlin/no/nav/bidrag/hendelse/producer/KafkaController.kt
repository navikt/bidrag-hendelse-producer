package no.nav.bidrag.hendelse.producer
import org.apache.kafka.common.requests.ProduceRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kafka")
class KafkaController(@Autowired val producer: Producer){

    @GetMapping("/")
    fun index():String{
        return "Velkommen til Bidrag hendelse Producer App"
    }

    @GetMapping("/publish")
    fun sendMessageToKafkaTopic(@RequestParam("message") message: String){
        producer.sendMessage(message);
    }

}
