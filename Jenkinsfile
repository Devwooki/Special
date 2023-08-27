pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // 소스 코드 체크아웃
                checkout scm
            }
        }

        stage('Build and Run Backend') {
            steps {
                dir('BackEnd') {
                    // Backend Dockerfile 빌드
                    sh 'docker-compose -f docker-compose.yml build'
                    // Backend 컨테이너 실행
                    sh 'docker-compose -f docker-compose.yml up -d server'
                }
            }
        }

        stage('Build and Run Frontend') {
            steps {
                dir('FrontEnd') {
                    // Frontend Dockerfile 빌드
                    sh 'docker-compose -f docker-compose.yml build'
                    // Frontend 컨테이너 실행
                    sh 'docker-compose -f docker-compose.yml up -d frontend'
                }
            }
        }
    }

    post {
        always {
            // 빌드 종료 후 Docker 컨테이너 정리
            sh 'docker-compose -f docker-compose.yml down'
        }
    }
}
