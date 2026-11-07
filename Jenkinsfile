pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/JnagmaHemaSekharaiah/ServiceObejectDesingPattern.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test Execution') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Reports') {
            steps {
                echo 'Check test execution reports'
            }
        }
    }
}