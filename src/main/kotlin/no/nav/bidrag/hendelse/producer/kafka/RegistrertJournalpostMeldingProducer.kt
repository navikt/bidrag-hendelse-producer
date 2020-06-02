package no.nav.bidrag.hendelse.producer.kafka

import no.nav.bidrag.hendelse.producer.dto.RegistrerJournalpostDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class RegistrertJournalpostMeldingProducer(@Autowired val kafkaTemplate: KafkaTemplate<String, RegistrerJournalpostDto>) {

    private val LOGGER: Logger = LoggerFactory.getLogger(RegistrertJournalpostMeldingProducer::class.java)

    @Value("\${kafka.topic}")
    private lateinit var TOPIC: String

    fun sendMelding(journalpostid: String, saksnummer: String) {
        LOGGER.info(String.format("Publiserer melding paa topic med journalpostid %s og saksnummer %s.", journalpostid, saksnummer))
        this.kafkaTemplate.send(TOPIC, RegistrerJournalpostDto(journalpostid, saksnummer))
    }
}
