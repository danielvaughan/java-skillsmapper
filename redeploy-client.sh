#!/usr/bin/env bash
cd client
./gradlew clean assemble cfPush

cf map-route client skillsmapper.site -n app