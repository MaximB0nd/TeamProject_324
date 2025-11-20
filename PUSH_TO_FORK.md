# Отправка кода в ваш форк репозитория

## Шаг 1: Узнайте ваш GitHub username

Ваш форк находится по адресу: `https://github.com/ВАШ_USERNAME/TeamProject_324`

Например, если ваш username `ilyaprokofev`, то URL будет: `https://github.com/ilyaprokofev/TeamProject_324`

## Шаг 2: Настройка и отправка кода

### Вариант A: Использование скрипта (проще)

1. **Откройте файл** `push-to-fork.sh`
2. **Замените** `YOUR_GITHUB_USERNAME` на ваш реальный GitHub username
3. **Запустите скрипт**:
   ```bash
   ./push-to-fork.sh
   ```

### Вариант B: Ручная настройка

1. **Добавьте ваш форк как remote**:
   ```bash
   git remote add fork https://github.com/ВАШ_USERNAME/TeamProject_324.git
   ```
   
   Или если remote уже существует:
   ```bash
   git remote set-url fork https://github.com/ВАШ_USERNAME/TeamProject_324.git
   ```

2. **Добавьте все изменения** (если есть):
   ```bash
   git add .
   git commit -m "Добавлены файлы для Jenkins и Docker"
   ```

3. **Отправьте в ваш форк**:
   ```bash
   git push -u fork Prokofev
   ```
   
   Или если ветка уже существует в форке:
   ```bash
   git push fork Prokofev
   ```

## Шаг 3: Проверка

Откройте ваш форк в браузере:
```
https://github.com/ВАШ_USERNAME/TeamProject_324
```

Убедитесь, что ветка `Prokofev` содержит ваши изменения.

## Шаг 4: Настройка Jenkins для работы с вашим форком

После отправки кода в форк, настройте Jenkins:

1. **Откройте Jenkins**: http://localhost:8080
2. **Откройте ваш Job**: `ILyaProkofev`
3. **Нажмите**: **Configure**
4. **В разделе Source Code Management**:
   - **Repository URL**: `https://github.com/ВАШ_USERNAME/TeamProject_324.git`
   - **Credentials**: выберите ваш GitHub токен (см. `GITHUB_TOKEN_GUIDE.md`)
   - **Branch Specifier**: `*/Prokofev`
5. **Сохраните**: нажмите **Save**

## Полезные команды

```bash
# Проверить все remotes
git remote -v

# Удалить remote fork (если нужно)
git remote remove fork

# Посмотреть текущую ветку
git branch

# Посмотреть статус
git status

# Отправить конкретную ветку
git push fork имя_ветки

# Создать новую ветку в форке
git push -u fork новая_ветка
```

## Что будет отправлено

Следующие файлы будут отправлены в ваш форк:
- `docker-compose.yml` - конфигурация Jenkins
- `Jenkinsfile` - Pipeline для CI/CD
- `README_JENKINS.md` - инструкция по Jenkins
- `SSH_SETUP.md` - настройка SSH
- `GITHUB_TOKEN_GUIDE.md` - создание токена
- `start-jenkins.sh` и `stop-jenkins.sh` - скрипты запуска
- Все ваши изменения в ветке `Prokofev`

## Решение проблем

### Ошибка "remote fork already exists"
```bash
git remote remove fork
git remote add fork https://github.com/ВАШ_USERNAME/TeamProject_324.git
```

### Ошибка "authentication failed"
- Убедитесь, что используете Personal Access Token
- См. инструкцию в `GITHUB_TOKEN_GUIDE.md`

### Ошибка "repository not found"
- Проверьте, что форк создан: https://github.com/ВАШ_USERNAME/TeamProject_324
- Убедитесь, что username указан правильно

