tools {
    'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
}

pipeline {
	agent any

	stages {
		stage("Prepare") {
			steps {
				sh "export PATH=/Users/rrkamalov/opt/anaconda3/bin:/Users/rrkamalov/opt/anaconda3/condabin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Users/rrkamalov/bin:/opt/X11/bin:/Library/Apple/usr/bin"
				git branch: 'main', credentialsId: 'git-cred', url: 'git@github.com:rkamalov/java-app.git'
			}
		} //Stage Prepare
	
		stage("Build Image") {
			steps {
				// sh 'docker build --file ${WORKSPACE}/docker/Dockerfile --tag gedgrus/java-app:latest .'
			script {
				def dockerImage = docker.build("gedgrus/java-app", "-f ${WORKSPACE}/docker/Dockerfile .")
			// 	docker.withRegistry('', 'dockerhub-cred') {
			// 		dockerImage.push()
			// 		dockerImage.push("latest")
			// 	}
			}
			}
		} //Stage Build Image

		stage("Push Image") {
			steps {
				sh "docker"
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
