pipeline {
    agent {
        docker {
            image 'gis4fun.org/openjdk:11'
            args '-v $HOME/.m2:/root/.m2 -u root'
        }
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}