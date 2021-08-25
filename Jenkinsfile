#!/bin/bash

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
