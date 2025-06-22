# 🎟️ Coupon Thrift Service

This is a standalone microservice implemented in Java using Apache Thrift.  
It provides RPC methods for coupon validation and discount calculation, and is designed to be part of a larger e-commerce system.

---

## 🧩 Features

- ✅ Validate coupon codes
- 💰 Calculate discount amounts
- 🧵 Apache Thrift RPC server
- 📦 Dockerized for easy deployment

---

## 🚀 How to Build & Run

### 1. Build the project

This service depends on the `coupon-thrift-api` module which contains the Thrift interface definitions and generated Java classes.  
Make sure to add `coupon-thrift-api` as a Maven dependency.

```bash
mvn clean package
```

### 2. Run with Docker (single container)
You can build and run this service as a Docker container:
```bash
docker build -t coupon-thrift-service .
docker run -p 9090:9090 coupon-thrift-service
```
Note: For multi-service environments, 
use the top-level docker-compose.yml from the main orchestration project (e.g., ecommerce-system).

## 📡 API Methods
| Method              | Parameters                     | Description                         |
| ------------------- | ------------------------------ | ----------------------------------- |
| `validateCoupon`    | `String code`                  | Check if a coupon code is valid     |
| `calculateDiscount` | `String code`, `double amount` | Return discount amount for a coupon |

## 🧪 Example Codes Supported
- DISCOUNT10 → 10% off
- WELCOME5 → $5 off

## 📦 Dependencies
- Java 17
- Apache Thrift 0.21.0
- Maven
- Docker (optional)
- coupon-thrift-api (Thrift interface module)
