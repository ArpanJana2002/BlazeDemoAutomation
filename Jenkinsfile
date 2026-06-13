pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        success {
            emailext(
                subject: "SUCCESS : BlazeDemo Automation Build #${BUILD_NUMBER}",
                body: """
                    Build Successful

                    Project: BlazeDemoAutomation
                    Build Number: ${BUILD_NUMBER}

                    Selenium Test Execution Completed Successfully.
                """,
                to: "your-email@gmail.com"
            )
        }

        failure {
            emailext(
                subject: "FAILED : BlazeDemo Automation Build #${BUILD_NUMBER}",
                body: """
                    Build Failed

                    Project: BlazeDemoAutomation
                    Build Number: ${BUILD_NUMBER}

                    Please check Jenkins Console Output.
                """,
                to: "your-email@gmail.com"
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
