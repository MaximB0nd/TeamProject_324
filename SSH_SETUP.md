# Настройка SSH ключа для доступа к GitHub репозиторию

## Ваш публичный SSH ключ

```
ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIAofmTUNRWLgVD5eA2cqrKx/x69tXPbmcVlUmVcud0WN your_email@example.com
```

## Шаг 1: Добавление ключа в GitHub

1. **Откройте GitHub**: https://github.com/settings/keys
2. **Нажмите "New SSH key"** (зеленая кнопка)
3. **Заполните форму**:
   - **Title**: `MacBook-Air-Ilya` (или любое понятное название)
   - **Key type**: `Authentication Key`
   - **Key**: Вставьте ключ выше (уже скопирован в буфер обмена)
4. **Нажмите "Add SSH key"**
5. **Подтвердите пароль GitHub** (если потребуется)

## Шаг 2: Проверка подключения

Выполните в терминале:
```bash
ssh -T git@github.com
```

Ожидаемый ответ:
```
Hi MaximB0nd! You've successfully authenticated, but GitHub does not provide shell access.
```

## Шаг 3: Изменение remote URL на SSH (опционально)

Если хотите использовать SSH вместо HTTPS для Git:

```bash
# Проверить текущий remote
git remote -v

# Изменить на SSH
git remote set-url origin git@github.com:MaximB0nd/TeamProject_324.git

# Проверить изменения
git remote -v
```

Теперь можно использовать:
```bash
git push
git pull
```

## Шаг 4: Настройка SSH ключа для Jenkins

Для того, чтобы Jenkins мог клонировать репозиторий через SSH:

1. **Откройте Jenkins**: http://localhost:8080
2. **Перейдите**: Manage Jenkins → Credentials → System → Global credentials
3. **Нажмите**: Add Credentials
4. **Заполните**:
   - **Kind**: SSH Username with private key
   - **ID**: `github-ssh-key`
   - **Username**: `git`
   - **Private Key**: Enter directly
   - **Key**: Вставьте содержимое приватного ключа:
     ```bash
     cat ~/.ssh/github_key
     ```
5. **Нажмите**: OK

## Использование в Jenkins Pipeline

В Jenkinsfile или в настройках Job используйте:

```groovy
checkout([
    $class: 'GitSCM',
    branches: [[name: '*/Prokofev']],
    userRemoteConfigs: [[
        credentialsId: 'github-ssh-key',
        url: 'git@github.com:MaximB0nd/TeamProject_324.git'
    ]]
])
```

Или в настройках Job:
- **Source Code Management**: Git
- **Repository URL**: `git@github.com:MaximB0nd/TeamProject_324.git`
- **Credentials**: выберите `github-ssh-key`

## Полезные команды

```bash
# Показать публичный ключ
cat ~/.ssh/github_key.pub

# Показать приватный ключ (для Jenkins)
cat ~/.ssh/github_key

# Скопировать публичный ключ в буфер обмена (macOS)
pbcopy < ~/.ssh/github_key.pub

# Проверить подключение к GitHub
ssh -T git@github.com

# Проверить текущий remote URL
git remote -v
```

## Решение проблем

### Ошибка "Permission denied (publickey)"
- Убедитесь, что ключ добавлен в GitHub
- Проверьте права на файлы: `chmod 600 ~/.ssh/github_key`

### Ошибка "Host key verification failed"
- Выполните: `ssh-keyscan github.com >> ~/.ssh/known_hosts`

### Jenkins не может клонировать репозиторий
- Проверьте, что приватный ключ правильно добавлен в Jenkins Credentials
- Убедитесь, что используется правильный credentialsId в Pipeline

