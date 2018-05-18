pipeline {
  agent any
  tools {
    maven 'aaa'
  }
  stages {
    stage('prom-app checkout') {
      parallel {
        stage('prom-app') {
          stage('prom-app checkout') {
            agent any
            steps {
              git(credentialsId: 'gitlab-prom', url: 'git@wmpf-git.prometeia:progetti/prom-app.git', branch: 'develop')
            }
          }
          stage('build') {
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
          stage('build') {
            steps {
              sh 'mvn clean install -DskipTests'
            }
          }
        }
      }
    }
  }
}
