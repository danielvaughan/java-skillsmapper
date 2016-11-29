#!/usr/bin/env bash
cd ./client
./gradlew clean assemble cfPush
cd ../server
./gradlew clean assemble cfPush

cf map-route client skillsmapper.site -n app
cf map-route client skillsmapper.site -n www
cf map-route server skillsmapper.site -n api
