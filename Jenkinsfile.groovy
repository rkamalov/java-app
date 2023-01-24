
pipeline {
	agent any

	stages {
		stage("Stage1") {
			steps {

			}
		} //Stage1
	
		stage("Stage2") {
			steps {

			}
		} //Stage2

		stage("Stage3") {
			steps {

			}
		} //Stage3
		stage("Stage4") {
			steps {

			}
		} //Stage4

		stage("Stage5") {
			steps {

			}
		} //Stage5

	} //stages


	post {
		always {
			
		}

		success {
		
		}

		failure {

		}
	} //post
} //pipeline
