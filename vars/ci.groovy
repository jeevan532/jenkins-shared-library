def call () {
    try {
        node ('agent') {
            stage ('clean workspace') {
                cleanWs()
            }
            stage('compile/build') {
                common.compile()
            }
            stage ('unittest') {
                common.unittest()
            }
            stage ('quality control') {
                sonar_user = sh (script: 'aws --region=us-east-1 ssm get-parameter --name "sonar.user" --with-decryption --output text --query Parameter.Value', returnStdout: true).trim()
                sonar_password = sh (script: 'aws --region=us-east-1 ssm get-parameter --name "sonar.password" --with-decryption --output text --query Parameter.Value', returnStdout: true).trim()
                wrap([$class: "MaskPasswordsBuildWrapper", varPasswordPairs: [[password: ${sonar_password}]]]) {
                sh " sonar-scanner -Dsonar.host.url=http://172.31.43.149:9000 -Dsonar.login=admin -Dsonar.password=Jeevan@05324u -Dsonar.projectKey=${component} ${extra_opt}"
            }
        }
    } catch (Exception e) {
       common.email(e,'failed')
        echo "test failed"
    }
}

