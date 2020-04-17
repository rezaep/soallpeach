FROM oracle/graalvm-ce:20.0.0-java11 AS build

COPY PrimeChecker.java .
RUN javac PrimeChecker.java

FROM openjdk:11-jre-slim

COPY --from=build PrimeChecker.class PrimeChecker.class

ENTRYPOINT ["java", "PrimeChecker"]