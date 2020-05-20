package no.nav.bidrag.hendelse.producer.controller
import no.nav.bidrag.hendelse.producer.kafka.RegistrertJournalpostMeldingProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kafka")
class RegistrertJournalpostRestController(@Autowired val registrertJournalpostMeldingProducer: RegistrertJournalpostMeldingProducer){

    @GetMapping("/")
    fun index():String{
        return "Velkommen til Bidrag hendelse Producer App"
    }

    @PostMapping("/publish")
    fun publishRegistrertJournalpostMeldingPaaTopic(@RequestBody registrerJournalpostForm:RegisterJournalpostForm){
        registrertJournalpostMeldingProducer.sendMelding(registrerJournalpostForm.journalpostid,registrerJournalpostForm.saksnummer);
    }

}
