pipeline {
    agent any
    stages {
        stage('build') {
            steps {
				sh './build'
            }
        }
        stage('test') {
            steps {
                echo "Testing "
            }
        }
         stage('deploy') {
            steps {
                echo "Deploying "
            }
        }
    }
}
