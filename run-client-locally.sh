#!/usr/bin/env bash
cd client
./gradlew clean build
java -jar ./build/libs/skillsmapper-client-0.1.0.jar