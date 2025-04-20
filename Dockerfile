# Usa Java 17 como base (compatible con tu pom.xml)
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copia el .jar compilado
COPY target/*.jar app.jar

# Comando para ejecutar tu app
ENTRYPOINT ["java", "-jar", "app.jar"]
