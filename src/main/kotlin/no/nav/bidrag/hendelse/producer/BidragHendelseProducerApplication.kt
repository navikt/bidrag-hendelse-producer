package no.nav.bidrag.hendelse.producer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
class BidragHendelseProducerApplication

fun main(args: Array<String>) {
	runApplication<BidragHendelseProducerApplication>(*args)
}
