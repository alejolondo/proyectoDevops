FROM maven:3.9

RUN mkdir -p /usr/src/myapp

COPY . /usr/src/myapp

WORKDIR /usr/src/myapp

RUN mvn clean install

CMD ["java", "-jar", "target/BooksClub-0.0.1-SNAPSHOT.jar"]