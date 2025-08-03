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
<<<<<<< HEAD
                sh 'mvn clean test -DsuiteXmlFile=campaign_testng.xml'
=======
                sh 'mvn clean test -DsuiteXmlFile=leadtests.xml'
>>>>>>> 4003c0f4444b173c977d69f7966f648f459d5cb0
            }
        }
    }

    post {
    always {
	        junit allowEmptyResults: true, testResults: '**/surefire-reports/TEST-*.xml'
	        archiveArtifacts allowEmptyArchive: true, artifacts: 'target/surefire-reports/*.txt'
	        archiveArtifacts allowEmptyArchive: true, artifacts: '**/*.html'
    	}
	}
}


