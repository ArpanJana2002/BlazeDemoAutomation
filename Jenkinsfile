pipeline {
    agent any

    tools {
        jdk 'JDK21'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Verify Environment') {
            steps {
                bat 'java -version'
                bat '"C:\\Program Files\\Apache\\apache-maven-3.9.16\\bin\\mvn.cmd" -version'
            }
        }

        stage('Build & Test') {
            steps {
                bat '"C:\\Program Files\\Apache\\apache-maven-3.9.16\\bin\\mvn.cmd" clean test -Dheadless=true'
            }
        }
    }

    post {

        always {

            archiveArtifacts(
                artifacts: 'reports/**, test-output/**',
                allowEmptyArchive: true
            )

            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'reports',
                reportFiles: 'AutomationReport.html',
                reportName: 'Extent Report'
            ])
        }

        success {
            echo 'BlazeDemo Automation Execution Successful'
        }

        failure {
            echo 'BlazeDemo Automation Execution Failed'
        }
    }
}
