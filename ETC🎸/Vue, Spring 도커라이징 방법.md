# Vue Dockerizing

> 모두 생략하고 4번만 실행하면 된다.

1. `/Front` 위치에서 `npm run build` 실행

2. `/Front` 위치에서 `Dockerfile` 생성

   ```yaml
   FROM node:lts-alpine as build-stage
   WORKDIR /app
   COPY package*.json ./
   RUN npm install --production
   COPY . .
   RUN npm run build
   
   # production stage
   FROM nginx:stable-alpine as production-stage
   COPY --from=build-stage /app/dist /usr/share/nginx/html
   EXPOSE 80
   CMD ["nginx", "-g", "daemon off;"]
   ```

3.  `/Front` 위치에서`sudo docker build -t hotoron/jaringulbi-vue-dockerize:v7 .`

4. `sudo docker push hotoron/jaringulbi-vue-dockerize:v7` : 허브에 이미지 푸시

5. `/Front` 위치에서 `sudo docker run -d -p 80:80 --rm --name jaringulbi-vue hotoron/jaringulbi-vue-dockerize:v7` 실행



# Spring Dockerizing

1. `/Back` 위치에서 `sudo chmod 777 ./gradlew` 실행

2. `/Back` 위치에서 `sudo ./gradlew build` 실행

3. `/Back` 위치에서 `cd build/libs` 실행

4. `/Back/build/libs` 위치에서 `java -jar B303-0.0.1-SNAPSHOT.jar ` : 빌드파일이 잘 만들어졌는지 확인

5. `cp B303-0.0.1-SNAPSHOT.jar ~/` : 도커 설치한 위치로 jar 파일 이동

6. `sudo docker search jdk` : jdk가 설치된 docker image 찾기

   ![image](https://user-images.githubusercontent.com/26705587/129311355-6f2577d2-62da-44ae-8f7f-4139e4e23f8d.png)

7. `docker pull openkbs/jdk11-mvn-py3` : 원하는 버전의 jdk+그래들이 설치된 도커 이미지 다운

8. `~/` 위치에서 Dockerfile 작성

   ```yaml
   FROM openkbs/jdk11-mvn-py3
   ADD B303-0.0.1-SNAPSHOT.jar app.jar
   ENV JAVA_OPTS=""
   ENTRYPOINT ["java","-jar","app.jar"]
   ```

9. `~/` 위치에서 `sudo docker build -t hotoron/jaringulbi-spring-dockerize:v5 .`

10. `docker push hotoron/jaringulbi-spring-dockerize:v5`

11. `~/` 위치에서 `sudo docker run -d -p 8399:8399 --rm --name jaringulbi-spring hotoron/jaringulbi-spring-dockerize:v5`









 651  docker build --tag jaringulbi-spring:0.1 ./
  652  sudo docker build --tag jaringulbi-spring:0.1 ./
  653  sudo docker images
  654  sudo docker run -p 8081:8399 jaringulbi-spring:0.1
  655  vi Dockerfile 
  656  sudo docker build --tag jaringulbi-spring:0.2 ./
  657  sudo docker run -p 8081:8399 jaringulbi-spring:0.2
  658  sudo docker ps -a
  659  history
  660  sudo docker login
  661  sudo docker build --tag hotoron/jaringulbi-spring:0.2 ./
  662  sudo docker push hotoron/jaringulbi-spring:0.2 ./
  663  sudo docker push hotoron/jaringulbi-spring:0.2







## 사용중인 포트 확인 및 프로세스 죽이기

1. `sudo lsof -i:포트번호` : 포트번호 사용중인지, PID알아내기 ex) `sudo lsof -i:8080`
2. `sudo kill -p PID` : 프로세스 삭제 ex)  `sudo kill -p 303241`

![image-20210819234823712](C:\Users\hotoron\AppData\Roaming\Typora\typora-user-images\image-20210819234823712.png)

