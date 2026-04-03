
pipeline {
  agent any
  tools {
    maven 'maven'
  }
  stages {
    stage("init") {
      steps {
        script {
          echo "init app..."
        }
      }
    }
    stage("build jar") {
      steps {
        script {
          echo "building the application..."
          sh "mvn package"
        }
      }
    }
    stage("build image") {
      steps {
        script {
          echo "building docker image..."
          withCredentials([usernamePassword(credentialsId: '46ac955a-53ea-4d8c-9369-a895c8a6c0d3', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
              sh 'docker build -t 165.227.47.37:8083/java-app:1.0 .'
              sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin 165.227.47.37:8083'
              sh 'docker push 165.227.47.37:8083/java-app:1.0'
          }
        }
      }
    }
  }
}
