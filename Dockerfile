FROM navikt/java:13
LABEL maintainer="Team Bidrag" \
      email="nav.ikt.prosjekt.og.forvaltning.bidrag@nav.no"

ADD ./target/bidrag-hendelse-producer-*.jar app.jar
COPY init-scripts /init-scripts

EXPOSE 8080
