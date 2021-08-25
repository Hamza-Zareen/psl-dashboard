#!/bin/bash

pipeline {
    agent any
    stages {
        stage('build') {
            steps {
			sh './build.sh'
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
