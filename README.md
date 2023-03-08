# Team 3 Project: Cassandra app

## Requirements
- Java 8 or later 
- maven

### Cassandra Database
Create a datastax database or use an existing one by setting these environmental variables:
```
DATASTAX_CLIENT_ID=<datastax_client_id>
DATASTAX_CLIENT_SECRET=<datatax_client_secret>
```
and adding a "Secure Connct Bundle" (a zip file of credentials) to `env/<secure_bundle_zip>`



## Build
To build a jar file use
```
mvn package
```

## Run
```
java -jar target/team3_app-0.0.1-SNAPSHOT.jar
```