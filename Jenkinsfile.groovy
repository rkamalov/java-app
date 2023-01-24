

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
				tool name: 'docker', type: 'dockerTool'
				def dockerImage = docker.build("gedgrus/java-app", "-f ${WORKSPACE}/docker/Dockerfile .")
				// docker.withRegistry('', 'dockerhub-cred') {
				// dockerImage.push()
				// dockerImage.push("latest")
				// }
			}
			}
		} //Stage Build Image

		stage("Push Image") {
			steps {
			script {
				withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'password', usernameVariable: 'username')]) {
					sh '''
						docker login --username ${username} --password ${password}
						docker push gedgrus/java-app:latest
					'''

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
