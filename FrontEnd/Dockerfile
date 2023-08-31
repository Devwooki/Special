# Use Node.js v18 base image
# FROM : 이미지를 지정해준다.
FROM node:latest as frontend-builder

# Set the working directory in the container
# WORKDIR: RUN, CMD, ENTRYPOINT, ADD, COPY 에 정의된 명령어를 실행하는 작업 디렉터리 지정
RUN mkdir /app #경로 생성 후 작업 영역을 지정한다.
WORKDIR /app
# Copy package.json and package-lock.json를 컨테이너로 복사한다.
# RUN: 이후 depedanccy를 설치한다.
COPY package.json /app/package.json
RUN npm install
# RUN npm install react@scripts

# 소스를 작업 폴더로 복사한 후 최종 빌드를 수행한다.
COPY . /app
RUN npm run build

#============================================
# 이후 엔진엑스를 적용한다.
FROM nginx:latest
# ngix의 기본 설정을 삭제하고 앱에서 설정한 파일을 복사
RUN rm -rf /etc/nginx/conf.d
COPY conf /etc/nginx

# 위에서 생성한 앱의 빌드 산출물을 nginx의 샘플 앱이 사용하는 폴더로 이동
COPY --from=frontend-builder /app/build /usr/share/nginx/html

# 5173 포트 오픈하고 nginx 실행
EXPOSE 5173
CMD ["nginx", "-g", "daemon off;"]
