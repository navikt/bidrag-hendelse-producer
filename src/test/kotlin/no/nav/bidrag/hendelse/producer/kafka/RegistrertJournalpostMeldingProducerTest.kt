package no.nav.bidrag.hendelse.producer.kafka

import no.nav.bidrag.hendelse.producer.dto.RegistrerJournalpostDto
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.kafka.core.KafkaTemplate

@ExtendWith(MockitoExtension::class)
class RegistrertJournalpostMeldingProducerTest {

    @Mock
    private lateinit var kafkaTemplateMock: KafkaTemplate<String, RegistrerJournalpostDto>

    @Test
    fun `skal publisere melding med kafka template`() {

        // GIVEN
        val journalpostID: String = "001"
        val saksnummer: String = "1500000"
        val TOPIC: String = "bidrag-registrert-journalpost-v2"

        // WHEN
        val registrertJournalpostMeldingProducer = RegistrertJournalpostMeldingProducer(TOPIC, kafkaTemplateMock)
        registrertJournalpostMeldingProducer.sendMelding(journalpostID, saksnummer)


        Mockito.verify(kafkaTemplateMock).send("bidrag-registrert-journalpost-v2", RegistrerJournalpostDto(journalpostID, saksnummer))
    }

    @Test
    fun `skal init klassen`() {
        // GIVEN
        val TOPIC: String = "bidrag-registrert-journalpost-v2"
        // WHEN
        val registrertJournalpostMeldingProducer = RegistrertJournalpostMeldingProducer(TOPIC, kafkaTemplateMock)

        // THEN
        assertNotNull(registrertJournalpostMeldingProducer)
    }
}
