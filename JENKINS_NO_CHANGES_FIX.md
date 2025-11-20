# Решение проблемы "Нет изменений" в Jenkins

## Проблема

Jenkins показывает сообщение "Нет изменений" (No changes) и не выполняет сборку или пропускает некоторые этапы.

## Причины

1. **Jenkins сравнивает коммиты** - если текущий коммит уже был собран ранее, Jenkins может пропустить сборку
2. **Нет настроек триггеров** - Jenkins не знает, когда нужно проверять изменения
3. **Неправильная настройка Git в Job** - Jenkins не может правильно отслеживать изменения в ветке

## Решения

### Решение 1: Настройка Jenkins Job для принудительной сборки

1. **Откройте ваш Job в Jenkins**: `http://localhost:8080`

2. **Нажмите**: **Configure**

3. **В разделе "Build Triggers"**:
   - ✅ Отметьте **"Poll SCM"**
   - Введите расписание: `H/5 * * * *` (проверка каждые 5 минут)
   - Или `H * * * *` (проверка каждый час)

4. **В разделе "Pipeline"** → **"Advanced Project Options"**:
   - ✅ Отметьте **"Do not allow concurrent builds"** (опционально)
   - ✅ Отметьте **"Disable automatic SCM triggering"** (если хотите запускать вручную)

5. **В разделе "Source Code Management"** (если используете Freestyle):
   - **Repository URL**: `https://github.com/MaximB0nd/TeamProject_324.git`
   - **Credentials**: выберите ваш токен/ключ
   - **Branch Specifier**: `*/Prokofev`
   - **Additional Behaviours** → **Add** → **"Wipe out repository & force clone"** (для полной очистки)

6. **Сохраните**: нажмите **Save**

### Решение 2: Принудительный запуск сборки

Если нужно запустить сборку вручную, даже если нет изменений:

1. **Откройте ваш Job**
2. **Нажмите**: **Build with Parameters** (если настроено) или **Build Now**
3. В консоли сборки вы увидите, что сборка выполняется

### Решение 3: Очистка истории сборок

Если Jenkins "думает", что коммит уже был собран:

1. **Откройте ваш Job**
2. **Нажмите**: **Build History**
3. **Удалите старые сборки** (если нужно)
4. **Или**: **Configure** → **"Discard old builds"** → настройте политику удаления

### Решение 4: Проверка настроек Git в Job

1. **Configure** → **Pipeline**
2. **Definition**: **Pipeline script from SCM**
3. **SCM**: **Git**
4. **Repository URL**: `https://github.com/MaximB0nd/TeamProject_324.git`
5. **Credentials**: выберите правильные credentials
6. **Branch Specifier**: `*/Prokofev` или `origin/Prokofev`
7. **Script Path**: `Jenkinsfile`

### Решение 5: Использование Webhook (рекомендуется)

Для автоматической сборки при каждом push:

1. **В GitHub**:
   - Откройте репозиторий: `https://github.com/MaximB0nd/TeamProject_324`
   - **Settings** → **Webhooks** → **Add webhook**
   - **Payload URL**: `http://ВАШ_IP:8080/github-webhook/` (или используйте ngrok для локального Jenkins)
   - **Content type**: `application/json`
   - **Events**: выберите **Just the push event**
   - **Active**: ✅

2. **В Jenkins**:
   - **Configure** → **Build Triggers**
   - ✅ Отметьте **"GitHub hook trigger for GITScm polling"**

3. **Теперь при каждом push** Jenkins автоматически запустит сборку

## Проверка работы

После настройки:

1. **Сделайте небольшое изменение** в коде (например, добавьте комментарий)
2. **Закоммитьте и запушьте**:
   ```bash
   git add .
   git commit -m "Test: проверка Jenkins"
   git push origin Prokofev
   ```
3. **Проверьте Jenkins** - должна запуститься автоматическая сборка
4. **Проверьте логи** - в консоли сборки должно быть видно изменения

## Дополнительные настройки в Jenkinsfile

В `Jenkinsfile` уже добавлены:
- ✅ Триггер `pollSCM` для автоматической проверки изменений
- ✅ Опции для принудительной сборки
- ✅ Информация о текущем коммите в логах

## Полезные команды для отладки

```bash
# Проверить последний коммит
git log -1 --oneline

# Проверить текущую ветку
git branch

# Проверить remote URL
git remote -v

# Принудительно обновить ветку
git fetch origin
git reset --hard origin/Prokofev
```

## Если проблема сохраняется

1. **Проверьте логи Jenkins**:
   ```bash
   docker-compose logs -f jenkins
   ```

2. **Проверьте настройки Git credentials** в Jenkins:
   - **Manage Jenkins** → **Credentials** → **System** → **Global credentials**
   - Убедитесь, что credentials правильные

3. **Проверьте доступ к репозиторию**:
   - Jenkins должен иметь доступ к репозиторию
   - Проверьте токен/ключ в настройках

4. **Очистите workspace**:
   - В Job: **Workspace** → **Wipe Out Current Workspace**
   - Или вручную: удалите содержимое workspace

---

**Примечание**: Сообщение "Нет изменений" не всегда является ошибкой. Если вы запускаете сборку того же коммита повторно, это нормальное поведение. Для принудительной сборки используйте **Build Now** или настройте триггеры.

