package no.nav.bidrag.hendelse.producer.controller

import no.nav.bidrag.hendelse.producer.dto.RegistrerJournalpostDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.kafka.core.KafkaTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
internal class BidragHendelserProducerRestControllerTest {

    @Autowired
    private lateinit var testRestTemplate: TestRestTemplate

    @Value("\${server.servlet.context-path}")
    private lateinit var contextPath: String

    @MockBean
    private lateinit var kafkaTemplateMock: KafkaTemplate<String, RegistrerJournalpostDto>

    @Test
    fun `skal sette opp server servlet context path`() {
        assertThat(contextPath).isEqualTo("/bidrag-hendelse-producer")
    }

    @Test
    fun `skal opprette melding med kafka template`() {
        testRestTemplate.exchange(
                "http://localhost:8080/bidrag-hendelse-producer/hendelse/publish/journalpost/registrert",
                HttpMethod.POST,
                HttpEntity(RegisterJournalpostForm("101", "666")),
                String::class.java
        )

        verify(kafkaTemplateMock).send("bidrag-registrert-journalpost-v2", RegistrerJournalpostDto("101", "666"))
    }
}
