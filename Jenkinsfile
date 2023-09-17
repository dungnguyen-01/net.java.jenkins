pipeline {

    // environment {
    //     registry = "dungnguyen251001/net.java.jenkins"
    //     registryCredential = 'dockerhub'
    //     dockerImage = ''
    // }

    agent any

    tools {
        maven 'my-maven'
    }

    stages {
        stage('Build with maven') {
            steps {
                sh 'mvn --version'
                sh 'java --version'
                sh 'mvn clean'
           //     sh 'mvn update'
                sh 'mvn install'
            }
        }

        // stage('Build Docker Image') {
        //     steps {
        //         script {
        //             // Build the Docker image
        //            dockerImage = docker.build registry + ":0.0.0.1"
        //         }
        //     }
        // }

        // stage('Push Docker Image') {
        //     steps {
        //         script {
        //             // Push the Docker image
        //             //sh 'docker push dungnguyen251001/net.java.jenkins:0.0.0.1'

        //             docker.withRegistry( '', registryCredential ) {
        //             dockerImage.push()
        //             }
        //         }
        //     }
        // }

        stage('Packaging/Pushing image') {
            steps {
                withDockerRegistry(credentialsId: 'dockerhub', url: 'https://index.docker.io/v1/') {
                    sh 'docker build -t net.java.jenkins:0.0.0.1 .'
                    sh 'docker push dungnguyen251001/net.java.jenkins:0.0.0.1'
                }
            }
        }

        stage('Deploy Spring Boot to DEV') {
            steps {
                echo 'Deploying and Cleaning'
                sh 'docker pull dungnguyen251001/net.java.jenkins:0.0.0.1'
                sh 'docker stop net.java.jenkins_container || echo "this container does not exist"'
                sh 'echo y | docker container prune'
                sh 'docker run -dp 6060:6060 --name net.java.jenkins_container dungnguyen251001/net.java.jenkins:0.0.0.1 '
            }
        }
    }

    post {
        changed{
            emailext to: "dungholp2510@gmail.com",
            subject: "jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
            body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
        }
        always {
            cleanWs()
        }
    }
}



