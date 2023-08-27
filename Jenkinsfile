jenkins_token

pipeline {
    agent any
    options {
        timeout(time: 1, unit: 'HOURS') // set timeout 1 hour
    }
    environment {
        REPOSITORY_CREDENTIAL_ID = 'jenkins_token' // github repository credential name
        REPOSITORY_URL = 'https://github.com/Devwooki/Special.git'
        TARGET_BRANCH = 'dev'
        IMAGE_NAME = 'B303-Special-backend'
        CONTAINER_NAME = 'B303-Special-backend'
        //PROFILE = 'dev'
    }
    stages{
        stage('init') {
            steps {
                echo 'init stage'
                sh '''
                docker rm -f $CONTAINER_NAME
                '''
                deleteDir()
            }
            post {
                success {
                    echo 'success init in pipeline'
                }
            }
        }
        stage('clone project') {
            steps {
                git url: "$REPOSITORY_URL",
                    branch: "$TARGET_BRANCH",
                    credentialsId: "$REPOSITORY_CREDENTIAL_ID"
                sh "ls -al"
            }
            post {
                success {
                    echo 'success clone project'
                }
                failure {
                    error 'fail clone project' // exit pipeline
                }
            }
        }
        stage('dockerizing by gradle') {
            steps {
                script {
                    def gradleCmd = isUnix() ? './gradlew' : 'gradlew.bat'
                    def gradleOpts = isUnix() ? '' : '-Dorg.gradle.daemon=false'

                    def buildCmd = "${gradleCmd} bootBuildImage ${gradleOpts} -PimageName=${IMAGE_NAME} -x test"

                    sh buildCmd
                }
            }
            post {
                success {
                    echo 'success dockerizing by gradle'
                }
                failure {
                    error 'fail dockerizing by gradle' // exit pipeline
                }
            }
        }

        stage('deploy') {
            steps {
                // sh 'docker run --name $CONTAINER_NAME -e "SPRING_PROFILES_ACTIVE=$PROFILE" -d -p 8080:8080 -t $IMAGE_NAME'
                sh 'docker run --name $CONTAINER_NAME  -d -p 9999:9999 -t $IMAGE_NAME'
            }

            post {
                success {
                    echo 'success deploying B303-Special spring project'
                }
                failure {
                    error 'fail deploying B303-Special spring project' // exit pipeline
                }
            }
        }

    }

}