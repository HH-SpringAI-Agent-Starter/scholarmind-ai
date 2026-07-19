.PHONY: build run test clean docker-up docker-down logs

# Default target
all: build

## Build the project
build:
	./mvnw clean compile -DskipTests

## Run the application
run:
	./mvnw spring-boot:run

## Run tests
test:
	./mvnw test

## Package as JAR
package:
	./mvnw clean package -DskipTests

## Start infrastructure containers
docker-up:
	docker compose up -d

## Stop infrastructure containers
docker-down:
	docker compose down

## View logs
logs:
	docker compose logs -f

## Clean build artifacts
clean:
	./mvnw clean
	rm -rf target/

## Full rebuild
rebuild: clean docker-up
	./mvnw clean install -DskipTests
