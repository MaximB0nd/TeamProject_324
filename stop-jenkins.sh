#!/bin/bash

# Скрипт для остановки Jenkins

echo "=========================================="
echo "Остановка Jenkins"
echo "=========================================="

if ! command -v docker-compose &> /dev/null; then
    echo "❌ Docker Compose не установлен."
    exit 1
fi

echo "Останавливаю Jenkins..."
docker-compose stop

echo ""
echo "✅ Jenkins остановлен"
echo ""
echo "Для полного удаления контейнера (данные сохранятся):"
echo "docker-compose down"
echo ""
echo "Для полного удаления с данными:"
echo "docker-compose down -v"

