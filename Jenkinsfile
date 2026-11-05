//Please rename the file to Jenkinsfile in order to run it in the Jenkins
pipeline {
    agent any

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