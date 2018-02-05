node {
    // Clean workspace before doing anything
    deleteDir()
    // Mark the code checkout 'stage'....
    stage('Stage Checkout') {

        // Checkout code from repository and update any submodules
        checkout scm
    }
    stage('Get branch name') {
        //this will check the current branch (with *), and only keep the branch name (omit * and space)
        GIT_BRANCH = sh(
                script: 'git branch | grep \\* | cut -d \' \' -f2',
                returnStdout: true
        ).trim()
    }
    if(GIT_BRANCH == 'release_aws'){
        stage ('release') {
            //-Prelease.useAutomaticVersion=true -> net.researchgate.release plugin to allow auto increment of version
            sh "./gradlew clean build release -Prelease.useAutomaticVersion=true"
        }
    }else{
        stage('build and publish snapshot'){
            //branch to distinguish release_aws and other branches
            sh "./gradlew publish -Pbranch=$GIT_BRANCH"
        }
        stage (' initiate deploy job'){
            gradle_props_file = 'gradle.properties'
            artifact_props = readProperties file: gradle_props_file
            def paramList = []
            artifact_props.each { k, v -> paramList << string(name: k, value: v)    }
            print paramList
            build job: "deploy-aws-lambda", parameters: [[$class: 'StringParameterValue', name: 'hello', value: "hello"]]
        }
    }


}