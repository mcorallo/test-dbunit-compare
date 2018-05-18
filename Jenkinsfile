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
    stage('tools') {
      steps {
        tool(name: 'maven 3.5.3', type: 'maven')
        tool 'jdk8'
      }
    }
    stage('initialize') {
      steps {
        sh '''echo "PATH = ${PATH}"
echo "M2_HOME = ${M2_HOME}"'''
      }
    }
    stage('build') {
      steps {
        sh 'mvn clean install -DskipTests'
      }
    }
  }
}