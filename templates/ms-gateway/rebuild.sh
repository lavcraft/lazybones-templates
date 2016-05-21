#!/bin/bash

./gradlew ${projectName}:dB
docker-compose up -d ${projectName}
