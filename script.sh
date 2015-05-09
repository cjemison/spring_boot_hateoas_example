#!/bin/bash -e

rm -fr docker_build
mkdir docker_build
cp src/main/docker/Dockerfile docker_build
cp build/libs/getting-started-0.1.0.jar docker_build
cd docker_build
docker build -t sb_rest_svc:v1 .