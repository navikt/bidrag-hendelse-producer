package no.nav.bidrag.hendelse.producer

import no.nav.bidrag.hendelse.producer.dto.RegistrerJournalpostDto
import no.nav.bidrag.hendelse.producer.kafka.RegistrertJournalpostMeldingProducer
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.kafka.core.KafkaTemplate

@ExtendWith(MockitoExtension::class)
class ProducerTest {

    private inline fun <reified T : Any> mock() = Mockito.mock(T::class.java)

    @Test
    fun `should init class`() {
        // GIVEN
        val kafkaTemplate: KafkaTemplate<String, RegistrerJournalpostDto> = mock()

        // WHEN
        val registrertJournalpostMeldingProducer = RegistrertJournalpostMeldingProducer(kafkaTemplate)

        // THEN
        assertNotNull(registrertJournalpostMeldingProducer)
    }
}
