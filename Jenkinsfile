pipeline {
    agent any
    stages {
        stage('build') {
            steps {
				bat 'build'
			}
        }
        stage('test') {
            steps {
				bat 'test'
            }
        }
         stage('deploy') {
            steps {
				bat 'deploy'
            }
        }
    }
}
