package no.nav.bidrag.hendelse.producer.kafka

import no.nav.bidrag.hendelse.producer.dto.RegistrerJournalpostDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class RegistrertJournalpostMeldingProducer (@Autowired val kafkaTemplate: KafkaTemplate<String,RegistrerJournalpostDto>){

    @Value("\${kafka.topic}")
    private lateinit var TOPIC:String

    fun sendMelding(journalpostid:String, saksnummer:String) {
        this.kafkaTemplate.send(TOPIC,RegistrerJournalpostDto(journalpostid.toLong(), saksnummer.toLong()));
    }
}