# Requirenments
- Java 11 
- Maven
- Docker

# Building
`mvn clean install`

# Building docker image

First run commands from building, then  
`docker build --tag codechallange:latest ./`

# Running with docker

`docker run --name CodeChallange codechallange:latest`

Profiles can get set over environment variables like so:

`docker run --name -e PROFILE=prod CodeChallange codechallange:latest`

