pipeline {

            
               
                agent any
                
             
                
              stages {
                      
                  stage('Build') {
                      steps {
                        echo "Build new"
                        git url: 'https://github.com/ce5systems-demo/openshift-java-cicdapp.git'
                        sh './gradlew clean build'
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
                                          withSonarQubeEnv('sonarqube-odos') {
                                  sh './gradlew sonarqube'
                                          }
                                  script {
                                       def qg = waitForQualityGate()
                                       if (qg.status != 'OK') {
                                         error "Pipeline aborted due to quality gate failure: ${qg.status}"
                                       }
                                     }
                              }
                            
                          }
                          stage('OWASP') {
                            
                              steps {
                                 
                              echo "Owasp"
                        
                              }
                          }
                          stage('Analyse') {
                                      steps {
                                         echo "Analysis"
                                      }
                            }
                      }
                  }
                   
                   

                  stage('Docker Build') {
                      steps {
                           echo " image build"
                        
                      }
                  }

                  stage('Deploy') {
                      steps {
                          echo 'Deploying....'
                        
                      }
                  }
              }
              
               post { 

                  always {
                        
                         
             
          
                      publishHTML (target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: true,
                        reportDir: 'build/outputs/findbugs',
                        reportFiles: 'findbugs.html',
                        reportName: "FindBugs"
                      ])
                      
                    publishHTML (target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: true,
                        reportDir: 'build/outputs/checkstyle',
                        reportFiles: 'checkstyle.html',
                        reportName: "CheckStyle"
                      ])
                      
                       publishHTML (target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: true,
                        reportDir: 'build/outputs/pmd',
                        reportFiles: 'pmd.html',
                        reportName: "Pmd"
                      ])
                      
                      publishHTML (target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: true,
                        reportDir: 'build/outputs/jacoco',
                        reportFiles: 'index.html',
                        reportName: "JaCoCo"
                      ])
                      
                       publishHTML (target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: true,
                        reportDir: '/build/test-results/test',
                        reportFiles: '*.xml',
                        reportName: "Junit"
                      ])
                      
                      
                      sleep 20
                      
                      
                     
              
                  }
                  
                  
                  
                  

            }
          }
