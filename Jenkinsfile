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
        stage('Staging') {
            steps {
                 build job: 'deploy-to-staging'
            }    
        }
    }
}
