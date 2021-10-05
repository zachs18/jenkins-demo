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
                    archiveArtifacts artifacts: '**/*.war'
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
                sh 'curl -T webapp/target/webapp.war "http://tomcat:jenkins-demo@54.196.221.152:9090/manager/text/deploy?path=/webapp&update=true"'
            }    
        }
    }
}
