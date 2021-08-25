pipeline {
    agent any
    stages {
        stage('build') {
            steps {
				sh 'F:\psl-dashboard\.jenkins\build.sh'
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
