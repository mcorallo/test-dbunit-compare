pipeline {
  agent any
  tools {
    maven 'aaa'
  }
  stages {
    stage('all') {
      parallel {
        stage('prom-app') {
          stage('prom-app checkout') {
            agent any
            steps {
              git(credentialsId: 'gitlab-prom', url: 'git@wmpf-git.prometeia:progetti/prom-app.git', branch: 'develop')
            }
          }
          stage('prom-app build') {
            steps {
              sh 'mvn clean install -DskipTests'
            }
          }
        }
        stage('pfpweb28') {
          stage('pfpweb28 checkout') {
            steps {
              git(url: 'git@wmpf-git.prometeia:progetti/PFPWeb28.git', branch: 'develop', credentialsId: 'gitlab-prom')
            }
          }
          stage('pfpweb28 build') {
            steps {
              sh 'mvn clean install -DskipTests'
            }
          }
        }
      }
    }
  }
}
