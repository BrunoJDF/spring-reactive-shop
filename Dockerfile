FROM adoptopenjdk/openjdk:11:latest
COPY [".", "/usr/src/shopreactive"]
WORKDIR /usr/src/shopreactive
RUN javac ShopReactiveApplication.java
