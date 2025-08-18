pipeline {
    agent{
        label 'java'
    }

    environment{
        browserName='CHROME'
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
                bat mvn clean test -P pr-checks -D browserName=chrome
                echo ${browserName}
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
        }
    }
}
