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
      }
    }
    stage('') {
      steps {
        tool(name: 'maven 3.5.3', type: 'maven')
      }
    }
    stage('prom-app build') {
      steps {
        sh 'mvn -DskipTests clean install'
      }
    }
  }
}