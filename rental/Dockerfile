FROM openjdk:17-jdk-alpine
COPY target/*SNAPSHOT.jar app.jar
# 컨테이너가 실행될 포트 지정
#EXPOSE 8080
#ENV TZ=Asia/Seoul
#RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENTRYPOINT ["java","-Xmx400M","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=docker"]