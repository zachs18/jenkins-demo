pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                build job: 'packaging'
            }
            post {
                success {
                    echo 'build successful'
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
