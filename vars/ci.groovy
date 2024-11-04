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

def declare() {
  print "hello jeevan kumar"
}
