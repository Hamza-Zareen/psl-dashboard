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
        junit 'target/**/*.xml'
      }
    }

    stage('deploy') {
      steps {
        bat 'deploy'
      }
    }

  }
}