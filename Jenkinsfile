pipeline {
    agent maven

    stages {
        stage('Build') {
            steps {
               echo "Build empty"
               script {
                         
                            sh './gradlew clean build'
                    }
                }
            }
        }
     

        stage('Testing') {

            failFast true
            parallel {
                stage('Unit Testing') {
                  steps {
                        echo "Unit Test On Branch B"
                    }
                   
                }
                stage('Integration') {
                  
                    steps {
                        echo "Integration On Branch B"
                    }
                }

                stage('ATDD') {
                  
                    steps {
                        echo "ATDD On Branch B"
                    }
                }
            }
        }


        stage('Code Scan') {

            failFast true
            parallel {
                stage('Sonar') {
                     steps {
                        echo "Sonar On Branch B"
                    }
                   
                }
                stage('OWASP') {
                  
                    steps {
                        echo " OWASP On Branch B"
                        script {
                        sh './gradlew dependencyCheckAnalyze'
                        }
                    }
                }
            }
        }

         stage('Docker Build') {
            steps {
                dockerBuild()
               
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying....'
               
            }
        }
    }


    post { 
     

        failure {
            //slackNotify("FAILURE")
        }
 
        success {

          //  slackNotify("SUCCESS")

        }
        
        unstable {
           //  slackNotify("UNSTABLE")
        }
        

    }
}
