#!/bin/bash

# Скрипт для отправки кода в ваш форк репозитория

echo "=========================================="
echo "Отправка кода в ваш форк GitHub"
echo "=========================================="

# Замените YOUR_GITHUB_USERNAME на ваш реальный GitHub username
GITHUB_USERNAME="YOUR_GITHUB_USERNAME"  # <-- ЗАМЕНИТЕ НА ВАШ USERNAME!

if [ "$GITHUB_USERNAME" = "YOUR_GITHUB_USERNAME" ]; then
    echo "❌ Ошибка: Укажите ваш GitHub username в скрипте!"
    echo ""
    echo "Откройте файл push-to-fork.sh и замените YOUR_GITHUB_USERNAME"
    echo "на ваш реальный GitHub username"
    exit 1
fi

FORK_URL="https://github.com/${GITHUB_USERNAME}/TeamProject_324.git"
CURRENT_BRANCH=$(git branch --show-current)

echo "Ваш форк: $FORK_URL"
echo "Текущая ветка: $CURRENT_BRANCH"
echo ""

# Проверка наличия изменений
if [ -n "$(git status --porcelain)" ]; then
    echo "Найдены несохраненные изменения. Добавляю файлы..."
    git add .
    
    echo ""
    read -p "Введите сообщение коммита (или нажмите Enter для 'Update code'): " COMMIT_MSG
    COMMIT_MSG=${COMMIT_MSG:-"Update code"}
    
    git commit -m "$COMMIT_MSG"
    echo "✅ Изменения закоммичены"
fi

# Добавление remote для форка (если еще не добавлен)
if ! git remote | grep -q "fork"; then
    echo ""
    echo "Добавляю remote 'fork' для вашего форка..."
    git remote add fork "$FORK_URL"
    echo "✅ Remote добавлен"
else
    echo ""
    echo "Обновляю URL для remote 'fork'..."
    git remote set-url fork "$FORK_URL"
    echo "✅ Remote обновлен"
fi

# Отправка в форк
echo ""
echo "Отправляю код в ваш форк (ветка: $CURRENT_BRANCH)..."
git push fork "$CURRENT_BRANCH" || {
    echo ""
    echo "Попытка создать ветку в форке..."
    git push -u fork "$CURRENT_BRANCH"
}

echo ""
echo "=========================================="
echo "✅ Готово! Код отправлен в ваш форк"
echo "=========================================="
echo ""
echo "Ваш форк: https://github.com/${GITHUB_USERNAME}/TeamProject_324"
echo "Ветка: $CURRENT_BRANCH"
echo ""

