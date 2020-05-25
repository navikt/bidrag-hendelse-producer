package no.nav.bidrag.hendelse.producer.controller
import no.nav.bidrag.hendelse.producer.kafka.RegistrertJournalpostMeldingProducer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hendelse")
class BidragHendelserProducerRestController(@Autowired val registrertJournalpostMeldingProducer: RegistrertJournalpostMeldingProducer){

    private val LOGGER: Logger = LoggerFactory.getLogger(BidragHendelserProducerRestController::class.java)

    @PostMapping("publish/journalpost/registrert")
    fun publishRegistrertJournalpostMeldingPaaTopic(@RequestBody registrerJournalpostForm:RegisterJournalpostForm){
        LOGGER.info(String.format("Fikk en POST request om a publisere melding paa topic med journalpostid: %s og saksummer %s. ",
                registrerJournalpostForm.journalpostid, registrerJournalpostForm.saksnummer));
        registrertJournalpostMeldingProducer.sendMelding(registrerJournalpostForm.journalpostid,registrerJournalpostForm.saksnummer);
    }

}
