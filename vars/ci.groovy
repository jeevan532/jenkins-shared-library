def call () {
  
  pipeline {
    agent any
       stages {
          stage('compile') {
            steps {
              script {
                common.compile()
	          }
           }
         }
         stage('unit test') {
           steps {
             script{
               common.unittest()
            }
          }
        }
     }
  }
}

