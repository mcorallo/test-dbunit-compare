pipeline {
  agent any
  stages {
    stage('build') {
      agent any
      steps {
        timeout(time: 10) {
          retry(count: 2) {
            sh 'echo \'ciao\''
          }

        }

      }
    }
    stage('test') {
      steps {
        echo 'asdasda'
      }
    }
  }
}