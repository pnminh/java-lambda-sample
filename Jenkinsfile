node {
    // Clean workspace before doing anything
    deleteDir()
    // Mark the code checkout 'stage'....
    stage('Stage Checkout') {

        // Checkout code from repository and update any submodules
        checkout scm
    }

    stage ('release') {
        sh "./gradlew clean build release"
    }
}