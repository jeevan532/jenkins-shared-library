def compile() {
    if (app_lang == "nodejs") {
        sh 'npm install'
    }
    if (app_lang == "java") {
        sh 'mvn clean package'
    }
}
def unittest(){
    if(app_lang=="nodejs"){
        sh 'npm test || true'
    }
    if(app_lang=="java"){
        sh 'mvn test'
    }
    if(app_lang=="python"){
        sh 'python3 -m unittest'
    }
}
def email(){
    sh 'env'
}
