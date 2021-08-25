pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "Hi it's Building"
				echo "Hi it's Building"
            }
        }
        stage('test') {
            steps {
                echo "Testing "
				sh './test-all.sh'
            }
        }
         stage('deploy') {
            steps {
                echo "Deploying "
				sh './deploy.sh'
            }
        }
    }
}
