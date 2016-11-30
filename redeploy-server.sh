#!/usr/bin/env bash
cd server
./gradlew clean assemble cfPush

cf map-route server skillsmapper.site -n api
