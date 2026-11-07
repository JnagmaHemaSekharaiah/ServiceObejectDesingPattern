pipeline {
    agent any

options {
        skipDefaultCheckout(true)
    }


    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
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


/*

// pipeline {
//     agent any
//
//     options {
//         skipDefaultCheckout(true)
//     }
//
//     stages {
//
//         stage('Checkout') {
//             steps {
//                 git branch: 'master',
//                     url: 'https://github.com/JnagmaHemaSekharaiah/ServiceObejectDesingPattern.git'
//             }
//         }
//
//         stage('Build') {
//             steps {
//                 bat 'mvn clean compile'
//             }
//         }
//
//         stage('Smoke Testing') {
//             steps {
//                 bat 'mvn test -DsuiteXmlFile=Smoke.xml'
//             }
//         }
//
//         stage('Regression Testing') {
//             steps {
//                 bat 'mvn test -DsuiteXmlFile=Regression.xml'
//             }
//         }
//
//         stage('Reports') {
//             steps {
//                 junit '**/target/surefire-reports/*.xml'
//             }
//         }
//     }
// }




*/