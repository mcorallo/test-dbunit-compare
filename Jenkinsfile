pipeline {
  agent any
  tools {
    maven 'aaa'
  }
  options {
    buildDiscarder(logRotator(numToKeepStr: '3', artifactNumToKeepStr: '3'))
  }
  parameters {
    choice(choices: 'master\ndevelop', description: 'Which branch?', name: 'branch')
  }
  stages {
    stage('prom-app') {
        steps {
          git(credentialsId: 'gitlab-prom', url: 'git@wmpf-git.prometeia:progetti/prom-app.git', branch: "${params.branch}")
          sh 'mvn clean install -DskipTests'
        }
    }

    stage('pfpweb28') {
      steps {
        git(credentialsId: 'gitlab-prom', url: 'git@wmpf-git.prometeia:progetti/PFPWeb28.git', branch: "${params.branch}")
        sh 'mvn clean install -DskipTests'
      }
    } 

    stage('pfpweb28gui') {
      steps {
        git(credentialsId: 'gitlab-prom', url: 'git@wmpf-git.prometeia:progetti/pftpro-gui-edr.git', branch: 'master')
        sh './build.sh'
      }
    }         
  }
}

