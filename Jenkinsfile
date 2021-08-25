pipeline {
    agent any
    stages {
        stage('build') {
            steps {
				sh 'build.sh'
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
