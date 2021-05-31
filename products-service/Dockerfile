FROM openjdk:8
ADD target/products-service.jar products-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "products-service.jar"]