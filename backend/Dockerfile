FROM adoptopenjdk/openjdk15

WORKDIR /app
COPY ./build/libs .

EXPOSE 8080

ENTRYPOINT ["java","-jar","casino-backend-0.0.0.jar"]