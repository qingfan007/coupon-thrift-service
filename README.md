# 🎟️ Coupon Thrift Service

This project is a simple microservice written in Java using Apache Thrift. 
It provides two RPC methods for coupon validation and discount calculation, and is designed to be integrated into a larger e-commerce backend system.

---

## 🧩 Features

- ✅ Validate coupon codes
- 💰 Calculate discount amounts
- 🧵 Apache Thrift RPC server
- 📦 Dockerized for easy deployment

---

## 🚀 How to Build & Run

### 1. Generate Java interfaces from Thrift file
```bash 
please work in the project root

thrift --gen java -out src/main/java doc/thrift/coupon_service.thrift
```

### 2. Run with Docker
```bash
docker build -t coupon-thrift-service .
docker run -p 9090:9090 coupon-thrift-service
```

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
