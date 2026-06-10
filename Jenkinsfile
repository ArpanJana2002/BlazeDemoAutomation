pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }

    stages {

        stage('Checkout') {

            steps {

                git branch: 'main',
                    url: 'https://github.com/ArpanJana2002/BlazeDemoAutomation.git'
            }
        }

        stage('Build') {

            steps {

                bat 'mvn clean test'
            }
        }
    }

    post {

        success {

            emailext(
                subject: 'SUCCESS : BlazeDemo Automation',
                body: 'Flight booking automation executed successfully.',
                to: 'your-email@gmail.com'
            )
        }

        failure {

            emailext(
                subject: 'FAILED : BlazeDemo Automation',
                body: 'Build failed. Check Jenkins.',
                to: 'your-email@gmail.com'
            )
        }

        always {

            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'reports',
                reportFiles: 'AutomationReport.html',
                reportName: 'Extent Report'
            ])
        }
    }
}