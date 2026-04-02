def gv

pipeline {
  agent any
  environment {
    NEW_VERSION = '1.3.0'
  }
  parameters {
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
    booleanParam(name: 'executeTests', defaultValue: false, description: '')
  }
  tools {
    maven "maven"
  }
  stages {
    stage("init") {
      steps {
        script {
          gv = load "script.groovy"
        }
      }
    }
    stage("build") {

      steps {
        script {
          gv.build()
        }
      }

    }
    stage("test") {
      when {
        expression {
          params.executeTests
        }
      }
      steps {
        echo 'testing the application...'
      }
    }
    stage("deploy") {
      input {
        message "Select the environment: "
        ok "Done"
        parameters {
          
          choice(name: 'ENV', choices: ['dev', 'staging', 'prod'], description: '')
        }
      }
      steps {
        echo 'deploy the application...'
        echo "deploy version ${params.VERSION}"
        echo "deploy to ${ENV}"
      }
    }

  }

}
