# 이미지 지정
FROM openjdk:11

#ARG : docker build 명렁어를 사용할 때 입력받을 수 있는 인자 선언
ARG JAR_FILE=build/libs/*.jar

# copy 이미지에 파일이나 폴더 추가
COPY ${JAR_FILE} app.jar

# 컨테이너 내부에서 애플리케이션이 9999 포트에서 수신 대기하도록 설정하는 것
# - 컨테이너 내부에서만 유효하며
# 호스트OS에서 직접 접근할 수 있는 것은 아니다.
# spring boot 프로젝트 포트번호 : 1234
# spring boot 프로젝트 Dockerfile의 expose 9999
# -> docker run -d -p 1234:9999와 같다
EXPOSE 9999

# EntryPoint 컨테이너를실행할 때, 실행할 명령어를 지정해준다.
ENTRYPOINT [ "java" ,"-jar", "app.jar"]