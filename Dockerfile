FROM navikt/java:13
LABEL maintainer="Team Bidrag" \
      email="nav.ikt.prosjekt.og.forvaltning.bidrag@nav.no"

ADD ./producer/target/Bidrag-Hendelse-Producer-*.jar app.jar
COPY init-scripts /init-scripts

EXPOSE 8080
