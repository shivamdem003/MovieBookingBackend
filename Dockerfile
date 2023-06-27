FROM openjdk:17-alpine

VOLUME /tmp

COPY target/movie.jar movie.jar

ENTRYPOINT ["java", "-jar", "movie.jar"]