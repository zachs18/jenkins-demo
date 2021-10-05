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
                sh 'curl -T webapp/target/webapp.war "http://tomcat:jenkins-demo@54.196.221.152:9090/manager/text/deploy?path=/webapp&update=true"'
            }    
        }
    }
}
