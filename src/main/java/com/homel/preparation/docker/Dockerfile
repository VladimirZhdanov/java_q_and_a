FROM alpine:3.13 #Версия_образа_линукса_минимального

RUN apk add openjdk17 #При запуске контейнера выполним команду по установке JDK
COPY build/libs/app.jar /app.jar #Скопируем .jar и положем в папку в нашем образе под названием app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"] #Запуск нашего коннтейнера (список команд)
