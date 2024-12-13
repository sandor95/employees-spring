#!/bin/bash

original_dir=$(pwd)

docker rmi -f docker-nosql-emp-track-app docker-emp-track-app

cd docker || exit
docker compose up --force-recreate

cd "$original_dir" || exit