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

                sh 'mvn clean test -DsuiteXmlFile=campaign_testng.xml'


                sh 'mvn clean test -DsuiteXmlFile=testng_addProduct.xml'



                sh 'mvn clean test -DsuiteXmlFile=contacts.xml'


                sh 'mvn clean test -DsuiteXmlFile=opportunitytests.xml'



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


