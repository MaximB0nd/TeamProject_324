# Создание GitHub Personal Access Token для Jenkins

## Шаг 1: Создание Personal Access Token

1. **Войдите в GitHub** под вашим аккаунтом
   - Откройте: https://github.com/login

2. **Перейдите в настройки токенов**:
   - Нажмите на ваш аватар (правый верхний угол)
   - Выберите **Settings**
   - В левом меню выберите **Developer settings** (внизу списка)
   - Выберите **Personal access tokens** → **Tokens (classic)**
   - Или перейдите напрямую: https://github.com/settings/tokens

3. **Создайте новый токен**:
   - Нажмите **Generate new token** → **Generate new token (classic)**
   - GitHub может попросить подтвердить пароль

4. **Настройте токен**:
   - **Note** (название): `Jenkins CI/CD Access` (или любое понятное название)
   - **Expiration** (срок действия): выберите нужный период
     - Рекомендуется: `90 days` или `No expiration` (если это ваш личный токен)
   - **Select scopes** (права доступа): отметьте следующие:
     - ✅ **repo** (полный доступ к репозиториям)
       - Это включает: `repo:status`, `repo_deployment`, `public_repo`, `repo:invite`, `security_events`
     - ✅ **workflow** (если используете GitHub Actions)
     - ✅ **read:org** (если репозиторий в организации)

5. **Создайте токен**:
   - Прокрутите вниз и нажмите **Generate token** (зеленая кнопка)

6. **Скопируйте токен**:
   - ⚠️ **ВАЖНО**: Токен показывается только один раз!
   - Скопируйте его сразу и сохраните в безопасном месте
   - Токен выглядит примерно так: `ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx`

## Шаг 2: Добавление токена в Jenkins

### Вариант A: Если у вас есть доступ к репозиторию

1. **Откройте Jenkins**: http://localhost:8080

2. **Добавьте credentials**:
   - Перейдите: **Manage Jenkins** → **Credentials** → **System** → **Global credentials (unrestricted)**
   - Нажмите: **Add Credentials**

3. **Заполните форму**:
   - **Kind**: `Username with password`
   - **Scope**: `Global`
   - **Username**: ваш GitHub username (например, `ilyaprokofev` или тот, под которым вы вошли)
   - **Password**: вставьте **Personal Access Token** (не ваш пароль GitHub!)
   - **ID**: `github-token` (или любое понятное имя)
   - **Description**: `GitHub Personal Access Token`

4. **Сохраните**: нажмите **OK**

### Вариант B: Если у вас НЕТ доступа к репозиторию

Вам нужно попросить владельца репозитория (`MaximB0nd`) добавить вас как collaborator:

1. **Попросите владельца**:
   - Откройте репозиторий: https://github.com/MaximB0nd/TeamProject_324
   - Нажмите **Settings** (только владелец может)
   - Перейдите в **Collaborators**
   - Добавьте ваш GitHub username
   - Или отправьте ссылку-приглашение

2. **После получения доступа**:
   - Создайте Personal Access Token (как в Шаге 1)
   - Добавьте его в Jenkins (как в Варианте A)

## Шаг 3: Настройка Job в Jenkins

1. **Откройте ваш Job**: `ILyaProkofev`

2. **Нажмите**: **Configure**

3. **В разделе Source Code Management**:
   - **Repository URL**: `https://github.com/MaximB0nd/TeamProject_324.git`
   - **Credentials**: выберите созданный токен (например, `github-token`)
   - **Branch Specifier**: `*/Prokofev` (или нужная ветка)

4. **В расширенных настройках (Advanced)**:
   - **Refspec**: оставьте пустым (удалите отпечаток ключа, если он там)
   - **Name**: `origin` (или оставьте пустым)

5. **Сохраните**: нажмите **Save**

6. **Запустите сборку**: **Build Now**

## Альтернатива: Fork репозитория

Если вы не можете получить доступ к основному репозиторию:

1. **Сделайте Fork**:
   - Откройте: https://github.com/MaximB0nd/TeamProject_324
   - Нажмите кнопку **Fork** (правый верхний угол)
   - Создастся копия репозитория в вашем аккаунте

2. **Используйте ваш Fork**:
   - Repository URL в Jenkins: `https://github.com/ВАШ_USERNAME/TeamProject_324.git`
   - Используйте ваш Personal Access Token

3. **Синхронизация с оригиналом** (опционально):
   - Можете периодически делать Pull Request в основной репозиторий

## Проверка доступа

После настройки проверьте:

1. **В Jenkins**: запустите сборку и проверьте логи
2. **В терминале** (если нужно):
   ```bash
   # Проверка доступа с токеном
   curl -H "Authorization: token ВАШ_ТОКЕН" https://api.github.com/user
   ```

## Безопасность

⚠️ **Важные правила безопасности**:

- Никогда не коммитьте токен в код
- Не делитесь токеном публично
- Используйте минимально необходимые права (scopes)
- Регулярно обновляйте токены
- Удаляйте неиспользуемые токены

## Управление токенами

- Просмотр всех токенов: https://github.com/settings/tokens
- Удаление токена: нажмите на токен → **Delete**

## Решение проблем

### Ошибка "Authentication failed"
- Проверьте, что токен скопирован полностью
- Убедитесь, что токен не истек
- Проверьте права доступа токена (должен быть `repo`)

### Ошибка "Repository not found"
- Убедитесь, что у вас есть доступ к репозиторию
- Попросите владельца добавить вас как collaborator
- Или используйте Fork репозитория

### Ошибка "Permission denied"
- Проверьте, что токен имеет права `repo`
- Убедитесь, что используете правильный username в credentials

