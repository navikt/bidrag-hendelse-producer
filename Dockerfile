FROM navikt/java:15
LABEL maintainer="Team Bidrag" \
      email="nav.ikt.prosjekt.og.forvaltning.bidrag@nav.no"

ADD ./target/Bidrag-Hendelse-Producer-*.jar app.jar
COPY init-scripts /init-scripts

EXPOSE 8080