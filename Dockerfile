# Just as a side node, a docker file is not necessary for a spring boot application.
# My recommendation would be to use JIB and integrate the docker build in maven.
# This brings a lot of improvements to how the docker image is built, in terms of build speed and reusability.
# https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin

FROM adoptopenjdk/openjdk11:alpine-jre

COPY ./run.sh run.sh
RUN chmod +x /run.sh
COPY ./target/codechallange-*.jar app.jar

CMD ["sh", "-c", "/run.sh"]