#!/bin/bash

export MAVEN_ARGS=""
export MAVEN_OPTS=""

mvn clean verify -DskipTests -s ~/.m2/settings_basic.xml
