# 🧩 Proyecto de Microservicios — Registro Civil (CIBERTEC)

Este proyecto implementa una arquitectura de **microservicios con Spring Boot**, **Eureka**, **Spring Cloud Config**, **JWT** y **WebClient reactivo**.  
Simula un sistema de registro civil con gestión de ciudadanos y emisión de certificados (records).

---

## 🏗️ Arquitectura General

pgsql

                    +-----------------------+
                    |     Eureka Server     |
                    |   (Puerto 8761)       |
                    +-----------+-----------+
                                |
         +----------------------+----------------------+
         |                                             |
         v                                             v
+---------------------------+ +---------------------------+
| Auth Service | | Citizens Service |
| (JWT, Login/Register) | | (Datos de Ciudadanos) |
| Puerto: 8081 | | Puerto: 8082 |
+-------------+-------------+ +-------------+-------------+
| ^
| JWT Token |
v |
+---------------------------+ |
| Records Service |-------------------------------+
| (Actas: Nacimiento, etc.) |
| Puerto: 8084 |
+---------------------------+

yaml
Copiar código

---

## ⚙️ Servicios y Puertos

| Servicio             | Puerto | Descripción |
|----------------------|---------|-------------|
| **eureka-server**    | 8761 | Descubrimiento de servicios |
| **auth-service**     | 8081 | Autenticación con JWT |
| **citizens-service** | 8082 | Gestión de ciudadanos |
| **records-service**  | 8084 | Emisión de actas (usa WebClient y JWT) |

---

## 🧰 Tecnologías Usadas

- Spring Boot 3.3+
- Spring Cloud (Eureka, Config, Gateway)
- Spring Security + JWT
- Spring WebFlux (WebClient)
- PostgreSQL
- Lombok
- Maven

---

## 🚀 Ejecución del Proyecto

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/ronaldpalomin/microservicios-proyecto.git
cd microservicios-proyecto
2️⃣ Levantar los servicios en orden
bash
Copiar código
# Config Server
cd config-server
mvn spring-boot:run
bash
Copiar código
# Eureka Server
cd eureka-server
mvn spring-boot:run
bash
Copiar código
# Auth Service
cd auth-service
mvn spring-boot:run
bash
Copiar código
# Citizens Service
cd citizens-service
mvn spring-boot:run
bash
Copiar código
# Records Service
cd records-service
mvn spring-boot:run
3️⃣ Verificar en Eureka
Accede a 👉 http://localhost:8761
