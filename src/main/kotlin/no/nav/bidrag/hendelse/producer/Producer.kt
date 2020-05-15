package no.nav.bidrag.hendelse.producer

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class Producer (@Autowired val kafkaTemplate: KafkaTemplate<String,String>){

    private val logger: Logger = LoggerFactory.getLogger(Producer::class.java)
    @Value("\${app.topic}")
    private lateinit var TOPIC:String

    fun sendMessage(message: String?) {
        logger.info(String.format("$$ -> Produserer melding --> %s", message))
        this.kafkaTemplate.send(TOPIC,message);
    }
}