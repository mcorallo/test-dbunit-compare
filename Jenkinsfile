pipeline {
  agent any
  stages {
    stage('prom-app checkout') {
      parallel {
        stage('prom-app checkout') {
          agent any
          steps {
            git(credentialsId: 'gitlab-prom', url: 'git@wmpf-git.prometeia:progetti/prom-app.git', branch: 'develop')
          }
        }
        stage('pfpweb28-checkout') {
          steps {
            git(url: 'git@wmpf-git.prometeia:progetti/PFPWeb28.git', branch: 'develop', credentialsId: 'gitlab-prom')
          }
        }
        stage('pfpweb28gui-checkout') {
          steps {
            git(url: 'git@wmpf-git.prometeia:progetti/pftpro-gui-edr.git', branch: 'master', credentialsId: 'gitlab-prom')
          }
        }
      }
    }
  }
}