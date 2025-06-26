# Build stage: Maven + JDK 17
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Install Thrift 0.21.0
RUN apt-get update && apt-get install -y wget make g++
RUN wget https://archive.apache.org/dist/thrift/0.21.0/thrift-0.21.0.tar.gz && \
    tar xzf thrift-0.21.0.tar.gz && \
    cd thrift-0.21.0 && \
    ./configure --without-java && \
    make && make install

# Build Java project
WORKDIR /build
COPY . .
# KEY：only package coupon-thrift-service，but install all dependency modules
RUN mvn clean install -pl coupon-thrift-service -am -DskipTests

# Runtime stage: slim JRE only
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /build/coupon-thrift-service/target/*.jar app.jar

EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
