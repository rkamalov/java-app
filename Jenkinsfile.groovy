

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
			script {
				tool name: 'docker', type: 'dockerTool'
				def dockerImage = docker.build("gedgrus/java-app", "-f ${WORKSPACE}/docker/Dockerfile .")
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
		stage("Run app") {
			steps {
				withCredentials([file(credentialsId: 'kubecfg', variable: 'FILE')]) {
					sh "cat $FILE > kubernetes-cluster-5554_kubeconfig.yaml" 
					sh "sh ./setup2.sh"
				}
			}
		} //Stage4


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
