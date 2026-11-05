//Please rename the file to Jenkinsfile in order to run it in the Jenkins
pipeline {
    agent any

    //Due to the permissions, environment variable ('GRADLE_USER_HOME') is set as /var/jenkins_home/.gradle

    stages {
        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build --no-daemon --stacktrace'
            }
        }
    }

    post {
        always {
            junit '**/build/test-results/test/*.xml'
        }
        //success {
        //    archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
        //}
    }

}