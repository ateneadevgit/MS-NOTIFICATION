FROM openjdk:17-oracle
RUN mkdir data-shared
COPY target/ms-notification.jar ms-notification.jar
EXPOSE 8020
ENTRYPOINT ["java","-jar","/ms-notification.jar"]