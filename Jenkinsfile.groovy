
pipeline {
	agent any

	stages {
		stage("Stage1") {
			steps {
			echo "Stage 1"
			}
		} //Stage1
	
		stage("Stage2") {
			steps {
			echo "Stage 2"
			}
		} //Stage2

		stage("Stage3") {
			steps {
			echo "Stage 3"
			}
		} //Stage3
		stage("Stage4") {
			steps {
			echo "Stage 4"
			}
		} //Stage4

		stage("Stage5") {
			steps {
			echo "Stage 5"
			}
		} //Stage5

	} //stages


	post {
		always {
		echo "always"
		}

		success {
		echo "success"
		}

		failure {
		"failure"
		}
	} //post
} //pipeline
