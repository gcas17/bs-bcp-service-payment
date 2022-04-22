FROM openjdk:11-jre
COPY target/bs-bcp-service-payment-*SNAPSHOT.jar /opt/bs-bcp-service-payment.jar
ENTRYPOINT ["java","-jar","/opt/bs-bcp-service-payment.jar"]