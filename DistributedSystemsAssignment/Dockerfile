FROM maven:4.0.0-jdk-11
WORKDIR /DistributedSystemsAssignment
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run
