
pipeline {
	agent any

	stages {
		stage("Stage1") {
			steps {
			echo "Stage 1"

				// // This step should not normally be used in your script. Consult the inline help for details.
				// withDockerRegistry(credentialsId: 'dockerhub-cred', url: 'https://hub.docker.com/') {
    			// 	// some block
				// 	sh 'docker images'
				// }
				dir("docker") {
					sh 'docker build -t gedgrus/java-app:latest'
				}
				
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
		echo "failure"
		}
	} //post
} //pipeline
