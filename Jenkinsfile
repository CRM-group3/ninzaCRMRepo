pipeline {
    agent any
    
    tools {
        maven 'maveninstall'  // 👈 this tells Jenkins to use your configured Maven
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // This runs TestNG tests using your root-level testng.xml
                sh 'mvn clean test -DsuiteXmlFile=leadtests.xml'
            }
        }
    }

    post {
    always {
        // Archive JUnit-style reports from Maven Surefire
        junit allowEmptyResults: true, testResults: '**/surefire-reports/TEST-*.xml'

        // Archive raw Surefire report files (e.g., .txt files)
        archiveArtifacts allowEmptyArchive: true, artifacts: 'target/surefire-reports/*.txt'

        // Archive TestNG HTML reports (if generated)
        archiveArtifacts allowEmptyArchive: true, artifacts: 'test-output/**/*.html'
    }
}

}
