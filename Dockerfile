FROM openjdk:8
EXPOSE 8080
ADD target/k8-nagp.jar k8-nagp.jar
ENTRYPOINT ["java","-jar","/k8-nagp.jar"]