# Use Node.js v18 base image
# FROM : 이미지를 지정해준다.
FROM node:18-alpine  as frontend-builder

# Set the working directory in the container
# WORKDIR: RUN, CMD, ENTRYPOINT, ADD, COPY 에 정의된 명령어를 실행하는 작업 디렉터리 지정
RUN mkdir /app #경로 생성 후 작업 영역을 지정한다.
WORKDIR /app
# Copy package.json and package-lock.json를 컨테이너로 복사한다.
# RUN: 이후 depedanccy를 설치한다.
COPY package.json /app/package.json
RUN npm install
# RUN npm install react@scripts

# 소스를 작업 폴더로 복사한 후 정적 빌드을 최종 생성한다(index.html 등의 파일)
COPY . /app
RUN npm run build

#============================================
# 엔진엑스를 통해 정적 빌드파일을 web applicaion을 실행한다.
FROM nginx:latest

# ngix의 기본 설정을 삭제하고 앱에서 설정한 파일을 복사
# 오직 react build 파일을 실행하기 위한 nginx이기 때문에 신경쓰지 말자.
RUN rm -rf /etc/nginx/conf.d
COPY staticConf /etc/nginx

# 위에서 생성한 앱의 빌드 산출물을 nginx의 샘플 앱이 사용하는 폴더로 이동
COPY --from=frontend-builder /app/dist /usr/share/nginx/html

# 에러가 나타나면 페이지(html파일)을 nginx로 복사한다.
COPY ./404.html /usr/share/nginx/html
COPY ./50x.html /usr/share/nginx/html

# 컨테이너 내부 끼리 사용할 port를 허용해준다.5173 nginx 실행
EXPOSE 5173
CMD ["nginx", "-g", "daemon off;"]

# react프로젝트를 npm build -> react 정적 빌드를 한다.
# nginx를 사용해 정적 빌드파일(index.html)을 web applcation으로 띄운다

# 이후 호스트OS에 도커 컴포즈를 이용해 외부 nginx와 certbot 컨테이너를 띄운다
# 리버스 프록시를 통해 외부에서 접근하는 80포트와 443포트를 react나 spring으로 리다이렉트 시킨면 된다.
# 이때 네트워크 옵션을 사용하면 동일한 이름의 네트워크를 가진 nginx내부에서 연결을 하게 된다.