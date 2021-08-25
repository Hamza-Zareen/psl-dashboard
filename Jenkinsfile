#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
        stage('build') {
            steps {
				sh 'pwd'
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
