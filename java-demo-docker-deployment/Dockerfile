FROM alpine:3.19 as builder


RUN sed -i 's#dl-cdn.alpinelinux.org#mirrors.ustc.edu.cn#g' /etc/apk/repositories \
    && apk update \
    && apk add tzdata

RUN echo 'Asia/Shanghai' > /etc/timezone \
    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime



FROM amazoncorretto:8-alpine3.19-jdk
#LABEL com.jianlu8023.study-java.author=jianlu
MAINTAINER jianlu8023

ENV LANG=C.UTF-8

USER root

COPY --from=builder /etc/localtime /etc/localtime
COPY --from=builder /etc/timezone /etc/timezone


WORKDIR /usr/share/docker-deployment

COPY ./target/lib /usr/share/docker-deployment/lib
COPY ./target/config /usr/share/docker-deployment/config
COPY ./target/docker-deployment*.jar /usr/share/docker-deployment/docker-deployment.jar

RUN mkdir -p /usr/share/docker-deployment/logs

EXPOSE 8080

ENTRYPOINT ["java","-jar","docker-deployment.jar"]









