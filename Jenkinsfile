pipeline {
  agent any
  tools {
    maven 'aaa'
  }
  parameters {
    choice(choices: 'master\ndevelop', description: 'Which branch?', name: 'branch')
  }
  stages {
    stage('prom-app') {
        steps {
          git(credentialsId: 'gitlab-prom', url: 'git@wmpf-git.prometeia:progetti/prom-app.git', branch: ${params.branch})
          sh 'mvn clean install -DskipTests'
        }
    }

    stage('pfpweb28') {
      steps {
        git(credentialsId: 'gitlab-prom', url: 'git@wmpf-git.prometeia:progetti/PFPWeb28.git', branch: ${params.branch})
        sh 'mvn clean install -DskipTests'
      }
    }         
  }
}

