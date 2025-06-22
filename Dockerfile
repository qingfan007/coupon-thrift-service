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
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Runtime stage: slim JRE only
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/target/coupon-thrift-service-1.0-SNAPSHOT.jar coupon-thrift-service.jar

EXPOSE 9090
ENTRYPOINT ["java", "-jar", "coupon-thrift-service.jar"]
