### Run Quarkus as a native application

> ./mvnw install -Dnative
>
>Here we are getting build time exception, but in JVM mode it works perfectly fine.
>

###For running in JVM mode, run:
>./mvnw install
>
>java -jar target/quarkus-jasper-report-1.0-SNAPSHOT-runner.jar
>
## To test jasper report generation, trigger in the browser:

>localhost:8080/fruits