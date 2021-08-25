#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
        stage('build') {
            steps {
				dir(".jenkins/"){
					sh 'build.sh'
				}
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
