pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Build successful. Now archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'server/target/surefire-reports/*.xml'
                }
            }
        }
        stage('Staging') {
            steps {
                build job: 'deploy-to-staging'
            }    
        }
    }
}
