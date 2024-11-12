def call () {
 try {
     pipeline {
         agent {
             label 'workstation'
         }
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
             stage('quality control'){
                 steps {
                     sh "sonar-scanner -X -Dsonar.host.url=http://172.31.43.149:9000 -Dsonar.login=admin -Dsonar.password=Jeevan@05324u -Dsonar.projectKey=${component} "
                 }
             }
         }
     }
 }
     catch(Exception e) {
         common.email('failed')
     }
}

