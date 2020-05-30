pipeline {
   agent any
      triggers { pollSCM('H/15 * * * *') } // poll every 15 minutes
   environment {
       // use your actual issuer URL here and NOT the placeholder {yourOktaDomain}
       OKTA_OAUTH2_ISSUER           = 'https://dev-238367.okta.com/oauth2/default'
       OKTA_OAUTH2_CLIENT_ID        = credentials('OKTA_OAUTH2_CLIENT_ID')
       OKTA_OAUTH2_CLIENT_SECRET    = credentials('OKTA_OAUTH2_CLIENT_SECRET')
   }
   stages {
      stage('Build') {
         steps {
            // Get some code from a GitHub repository
            git 'https://github.com/wgcisotto/java-ci-jenkins-using-okta.git'
            // Run Maven on a Unix agent.
            sh "./mvnw -Dmaven.test.failure.ignore=true clean package"
            // To run Maven on a Windows agent, use
            // bat "mvn -Dmaven.test.failure.ignore=true clean package"
         }
         post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
               junit '**/target/surefire-reports/TEST-*.xml'
               archiveArtifacts 'target/*.jar'
            }
         }
      }
   }
}