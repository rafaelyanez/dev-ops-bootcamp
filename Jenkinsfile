def gv

pipeline {
  agent any
  tools {
    maven 'maven'
  }
  stages {
    stage("init") {
      steps {
        script {
          gv = load "script.groovy"
        }
      }
    }
    stage("build jar") {
      steps {
        script {
          gv.build()
        }
      }
    }
    stage("build image") {
      steps {
        script {
            gv.createImage()
          }
        }
      }
    }
  }
}
