def call () {
  
  pipeline {
    agent any
      stages {
        stage('compile') {
          steps {
            echo 'compile'
          }
        }
     }
  }
}
