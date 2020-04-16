FROM oracle/graalvm-ce:20.0.0-java11 AS build

RUN gu install native-image

COPY PrimeChecker.java .
RUN javac PrimeChecker.java

RUN native-image --static --no-server PrimeChecker

FROM alpine:latest

COPY --from=build primechecker primechecker

ENTRYPOINT ["./primechecker"]