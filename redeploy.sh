#!/usr/bin/env bash
cd ./client
./gradlew clean assemble cfPush
cd ../server
./gradlew clean assemble cfPush