pipeline {
    agent any
    
    tools {
        maven 'Maven-3.9.0'
        jdk 'JDK-17'
    }
    
    // Триггеры для автоматической сборки при изменениях
    triggers {
        // Проверка изменений каждые 5 минут
        pollSCM('H/5 * * * *')
    }
    
    options {
        // Всегда выполнять сборку, даже если нет изменений
        skipDefaultCheckout(false)
        // Не пропускать сборку, если нет изменений
        skipStagesAfterUnstable(false)
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Принудительный checkout с очисткой рабочей директории
                checkout scm
                // Показываем информацию о текущем коммите
                sh '''
                    echo "=== Git Information ==="
                    git log -1 --oneline
                    git branch -a
                    echo "======================"
                '''
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    publishTestResults testResultsPattern: 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
        
        stage('Allure Report') {
            steps {
                sh 'mvn allure:report'
            }
            post {
                always {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
    
    post {
        always {
            cleanWs()
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}

