def call () {
 try {
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
                     script {
                         common.unittest()
                     }
                 }
             }
         }
     }
 }
     catch(Exception e) {
         common.email()
     }
}

