pipeline {
    agent any
    tools {
        maven 'localMVN'
    }
    
    stages {
        stage('Build') {
            steps {
                build job: 'packaging'
            }
            post {
                success {
                    echo 'Build successful. Now archiving...'
                }
            }
        }
        stage(`Test') {
            steps {
                sh `mvn test'
            }
            post {
                always {
                    junit `target/surefire-reports/*.xml'
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
