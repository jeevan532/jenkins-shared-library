def compile() {
    if (app_lang == "nodejs") {
        sh 'npm install'
//        sh 'env'
    }
    if (app_lang == "java") {
        sh 'mvn clean package'
    }
}
//def unittest(){
//    if(app_lang=="nodejs"){
//        sh 'npm test'
//    }
//    if(app_lang=="java"){
//        sh 'mvn test'
//    }
//    if(app_lang=="python"){
//        sh 'python3 -m unittest'
//    }
//}
//def email(email_note){
//    mail bcc: '', body: 'job fialed-${JOB_BASE_NAME}\njenkins_url-${JOB_URL}', cc: '', from: 'jeev55534u@gmail.com', replyTo: '', subject: 'test form jenkins', to: 'jeev5324u@gmail.com'
//}
