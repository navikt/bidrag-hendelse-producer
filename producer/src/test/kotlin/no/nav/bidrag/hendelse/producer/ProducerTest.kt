package no.nav.bidrag.hendelse.producer

import no.nav.bidrag.hendelse.producer.dto.RegistrerJournalpostDto
import no.nav.bidrag.hendelse.producer.kafka.Producer
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.kafka.core.KafkaTemplate

@ExtendWith(MockitoExtension::class)
class ProducerTest {

    inline fun <reified T: Any> mock() = Mockito.mock(T::class.java)

    @Test
    fun shouldInitClass(){
        // GIVEN
        val kafkaTemplate:KafkaTemplate<String, RegistrerJournalpostDto> = mock();

        // WHEN
        val producer: Producer = Producer(kafkaTemplate)
        // THEN
        assertNotNull(producer)
    }
}