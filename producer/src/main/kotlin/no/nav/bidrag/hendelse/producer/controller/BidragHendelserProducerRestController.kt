package no.nav.bidrag.hendelse.producer.controller
import no.nav.bidrag.hendelse.producer.kafka.RegistrertJournalpostMeldingProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hendelse")
class BidragHendelserProducerRestController(@Autowired val registrertJournalpostMeldingProducer: RegistrertJournalpostMeldingProducer){

    @PostMapping("publish/journalpost/registrert")
    fun publishRegistrertJournalpostMeldingPaaTopic(@RequestBody registrerJournalpostForm:RegisterJournalpostForm){
        registrertJournalpostMeldingProducer.sendMelding(registrerJournalpostForm.journalpostid,registrerJournalpostForm.saksnummer);
    }

}
