node {
    // Clean workspace before doing anything
    deleteDir()
    // Mark the code checkout 'stage'....
    stage('Stage Checkout') {

        // Checkout code from repository and update any submodules
        checkout scm
    }
    branch = 'dev_aws'
    if(branch == 'release_aws'){
        stage ('release') {
            //-Prelease.useAutomaticVersion=true -> net.researchgate.release plugin to allow auto increment of version
            sh "./gradlew clean build release -Prelease.useAutomaticVersion=true"
        }
    }else{
        stage('build and publish snapshot'){
            sh "./gradlew publish"
        }
    }

}