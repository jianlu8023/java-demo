FROM amazoncorretto:8-alpine3.19-jdk
#LABEL com.jianlu8023.study-java.author=jianlu
MAINTAINER jianlu8023

ENV LANG=C.UTF-8

USER root


RUN sed -i 's#dl-cdn.alpinelinux.org#mirrors.ustc.edu.cn#g' /etc/apk/repositories \
    && apk update \
    && apk add tzdata

RUN echo 'Asia/Shanghai' > /etc/timezone \
    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime


WORKDIR /usr/share/java-study

COPY ./target/lib /usr/share/java-study/lib
COPY ./target/config /usr/share/java-study/config
COPY ./target/java-study*.jar /usr/share/java-study/java-study.jar

RUN mkdir -p /usr/share/java-study/logs

EXPOSE 8080

ENTRYPOINT ["java","-jar","java-study.jar"]









