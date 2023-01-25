FROM eclipse-temurin:11

RUN useradd -ms /bin/bash javauser

RUN mkdir -p /opt/java-app

ADD java-app.jar /opt/java-app
ADD application.properties /opt/java-app

CMD java -Dspring.config.location=/opt/java-app/application.properties -jar /opt/java-app/java-app.jar
