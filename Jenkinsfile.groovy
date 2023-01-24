
pipeline {
	agent any

	stages {
		stage("Prepare") {
			steps {

				// // This step should not normally be used in your script. Consult the inline help for details.
				// withDockerRegistry(credentialsId: 'dockerhub-cred', url: 'https://hub.docker.com/') {
    			// 	// some block
				// 	sh 'docker images'
				// }
				git branch: 'main', credentialsId: 'git-cred', url: 'git@github.com:rkamalov/java-app.git'
				sh 'ls -la'
				sh 'docker build --file ${WORKSPACE}/docker/Dockerfile --tag gedgrus/java-app:latest .'
				
				
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
