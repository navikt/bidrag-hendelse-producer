#!/usr/bin/env bash

if test -f /var/run/secrets/nais.io/srvbisys-dev/username;
then
    export  ABAC_USERNAME=$(cat /var/run/secrets/nais.io/srvbisys-dev/username)
else
  if test -f /var/run/secrets/nais.io/srvbisys-prod/username;
  then
      export  ABAC_USERNAME=$(cat /var/run/secrets/nais.io/srvbisys-prod/username)
  fi
fi

if test -f /var/run/secrets/nais.io/srvbisys-dev/password;
then
    export  ABAC_PASSWORD=$(cat /var/run/secrets/nais.io/srvbisys-dev/password)
else
  if test -f /var/run/secrets/nais.io/srvbisys-prod/password;
  then
      export  ABAC_PASSWORD=$(cat /var/run/secrets/nais.io/srvbisys-prod/password)
  fi
fi

if test -f /var/run/secrets/nais.io/srvbisys-prod/username;
then
    export  PIP_USERNAME=$(cat /var/run/secrets/nais.io/srvbisys-prod/username)
fi

if test -f /var/run/secrets/nais.io/srvbisys-prod/password;
then
    export  PIP_PASSWORD=$(cat /var/run/secrets/nais.io/srvbisys-prod/password)
fi

if test -f /var/run/secrets/nais.io/srvbidrag-dokument/username;
then
    export  SRVBIDRAG_DOKUMENT_USERNAME=$(cat /var/run/secrets/nais.io/srvbidrag-dokument/username)
fi
if test -f /var/run/secrets/nais.io/srvbidrag-dokument/password;
then
    export  SRVBIDRAG_DOKUMENT_PASSWORD=$(cat /var/run/secrets/nais.io/srvbidrag-dokument/password)
fi