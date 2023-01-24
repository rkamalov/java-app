

pipeline {
	agent any

	stages {
		stage("Prepare") {
			steps {
				git branch: 'main', credentialsId: 'git-cred', url: 'git@github.com:rkamalov/java-app.git'
			}
		} //Stage Prepare
	
		stage("Build Image") {
			steps {
				// sh 'docker build --file ${WORKSPACE}/docker/Dockerfile --tag gedgrus/java-app:latest .'
			script {
				def dockerImage = docker.build("gedgrus/java-app", "-f ${WORKSPACE}/docker/Dockerfile .")

			}
			}
		} //Stage Build Image

		stage("Push Image") {
			steps {
			script {
					docker.withRegistry('', 'dockerhub-cred') {
					dockerImage.push()
					dockerImage.push("latest")
				}
			}
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
		cleanWs()
		}

		success {
		echo "success"
		}

		failure {
		echo "failure"
		}
	} //post
} //pipeline
