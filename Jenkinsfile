pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "Hi it's Building"
				sh "build.sh"
            }
        }
        stage('test') {
            steps {
                echo "Testing"
				sh "test-all.sh"
            }
        }
         stage('deploy') {
            steps {
                echo "Deploying"
				sh "deploy.sh"
            }
        }
    }
}
