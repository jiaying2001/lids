FROM openjdk:17-oracle
LABEL authors="jiayinghuang"

ADD back_end-0.0.1-SNAPSHOT.jar /back_end-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar","back_end-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=production"]