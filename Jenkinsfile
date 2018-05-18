pipeline {
  agent any
  stages {
    stage('prom-app checkout') {
      agent any
      steps {
        git(credentialsId: 'gitlab-prom', url: 'git@wmpf-git.prometeia:progetti/prom-app.git', branch: 'develop')
      }
    }
  }
}