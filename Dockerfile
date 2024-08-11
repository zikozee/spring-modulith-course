# First stage: JDK with GraalVM
FROM ghcr.io/graalvm/jdk:21 AS build

RUN microdnf update -y && \
microdnf install -y gcc glibc-devel zlib-devel libstdc++-devel gcc-c++ && \
microdnf clean all

# Second stage
FROM debian:bookworm-slim

WORKDIR /opt/modulith

LABEL DEVELOPER='Ezekiel Eromosei<ezekiel.eromosei@test.com>'

EXPOSE 8081

COPY target/spring-modulith-course app

ENTRYPOINT ["./app"]