#!/bin/bash

# Скрипт для запуска Jenkins в Docker

echo "=========================================="
echo "Запуск Jenkins в Docker контейнере"
echo "=========================================="

# Проверка наличия Docker
if ! command -v docker &> /dev/null; then
    echo "❌ Docker не установлен. Пожалуйста, установите Docker сначала."
    exit 1
fi

# Проверка наличия Docker Compose
if ! command -v docker-compose &> /dev/null; then
    echo "❌ Docker Compose не установлен. Пожалуйста, установите Docker Compose сначала."
    exit 1
fi

echo "✅ Docker и Docker Compose найдены"

# Запуск Jenkins
echo ""
echo "Запускаю Jenkins..."
docker-compose up -d

# Ожидание запуска Jenkins
echo ""
echo "Ожидание запуска Jenkins (это может занять 30-60 секунд)..."
sleep 10

# Проверка статуса
if docker-compose ps | grep -q "jenkins.*Up"; then
    echo ""
    echo "✅ Jenkins успешно запущен!"
    echo ""
    echo "=========================================="
    echo "Jenkins доступен по адресу:"
    echo "http://localhost:8080"
    echo "=========================================="
    echo ""
    echo "Для получения начального пароля выполните:"
    echo "docker-compose exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword"
    echo ""
    echo "Или просмотрите логи:"
    echo "docker-compose logs -f jenkins"
    echo ""
else
    echo "❌ Ошибка при запуске Jenkins. Проверьте логи:"
    echo "docker-compose logs jenkins"
    exit 1
fi

