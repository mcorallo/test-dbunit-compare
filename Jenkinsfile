pipeline {
  agent any
  stages {
    stage('build') {
      agent any
      steps {
        timeout(time: 10) {
          sh 'echo \'ciao\''
        }

      }
    }
  }
}