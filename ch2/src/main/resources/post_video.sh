#!/usr/bin/env bash

curl -v -X POST localhost:8080/api/videos \
    -d '{"name":"Learning Spring Boot 3"}' \
    -H 'Content-type:application/json'

