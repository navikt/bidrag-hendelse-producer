package no.nav.bidrag.hendelse.producer.controller
import no.nav.bidrag.hendelse.producer.kafka.Producer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kafka")
class KafkaController(@Autowired val producer: Producer){

    @GetMapping("/")
    fun index():String{
        return "Velkommen til Bidrag hendelse Producer App"
    }

    @PostMapping("/publish")
    fun sendMessageToKafkaTopic(@RequestBody registrerJournalpostForm:RegisterJournalpostForm){
        producer.sendMessage(registrerJournalpostForm.journalpostid,registrerJournalpostForm.saksnummer);
    }

}
