pipeline {
  agent any
  tools {
    maven 'aaa'
  }
  stages {
    stage('all') {
      parallel {
        stage('prom-app') {
            steps {
              git(credentialsId: 'gitlab-prom', url: 'git@wmpf-git.prometeia:progetti/prom-app.git', branch: 'develop')
              sh 'mvn clean install -DskipTests'
            }
          }
        }
        stage('pfpweb28') {
            steps {
              git(url: 'git@wmpf-git.prometeia:progetti/PFPWeb28.git', branch: 'develop', credentialsId: 'gitlab-prom')
              sh 'mvn clean install -DskipTests'
            }
          }
        }
      }
    }
  }
}
