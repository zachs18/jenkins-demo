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
                sh 'curl -T webapp/target/webapp.war "http://user:password@VM_IP:9090/manager/text/deploy?path=/webapp&update=true"'
            }    
        }
    }
}
