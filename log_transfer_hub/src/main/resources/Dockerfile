FROM openjdk:17-oracle
LABEL authors="jiayinghuang"

ADD log_transfer_hub-0.0.1-SNAPSHOT.jar /log_transfer_hub-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar","log_transfer_hub-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=production"]