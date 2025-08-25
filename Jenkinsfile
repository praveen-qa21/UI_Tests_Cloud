pipeline {
    agent{
        label 'java'
    }

    environment{
        browserName='chrome'
    }


    stages {
        stage('setup stage') {
            steps {
                echo "Setup tasks go here"
            }
        }

        stage('execution stage') {
            steps {
                echo "hello world"
                echo "browserName:  ${browserName}"
                bat "mvn clean test -P pr-checks -DbrowserName=${browserName}"

            }
        }

        stage('teardown stage') {
            steps {
                echo "Teardown tasks go here"
            }
        }
    }

    post {
        always {
             echo "Reporting and cleanup tasks"
                       allure([
                           includeProperties: false,
                           jdk: '',
                           results: [[path: 'target/allure-results']]
                       ])
                   }
    }
}
