pipeline {
    agent any
    stages {
        stage('build') {
            steps {
				sh '.jenkins/build.sh'
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
