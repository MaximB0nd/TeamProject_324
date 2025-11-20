# Установка и настройка Jenkins в Docker

Это руководство поможет вам развернуть Jenkins локально внутри Docker-контейнера для CI/CD вашего Java проекта.

## Предварительные требования

1. **Docker** - должен быть установлен на вашей системе
   - Проверьте установку: `docker --version`
   - Если не установлен, скачайте с [docker.com](https://www.docker.com/get-started)

2. **Docker Compose** - должен быть установлен
   - Проверьте установку: `docker-compose --version`
   - Обычно входит в состав Docker Desktop

## Шаг 1: Запуск Jenkins

### Вариант 1: Использование Docker Compose (рекомендуется)

1. Откройте терминал в корневой директории проекта
2. Запустите команду:
   ```bash
   docker-compose up -d
   ```

3. Jenkins будет доступен по адресу: `http://localhost:8080`

### Вариант 2: Использование Docker напрямую

Если вы предпочитаете использовать команду `docker run`:

```bash
docker run -d \
  --name jenkins \
  -p 8080:8080 \
  -p 50000:50000 \
  -v jenkins_home:/var/jenkins_home \
  -v /var/run/docker.sock:/var/run/docker.sock \
  --restart unless-stopped \
  jenkins/jenkins:lts
```

## Шаг 2: Первоначальная настройка Jenkins

1. **Откройте Jenkins в браузере**: `http://localhost:8080`

2. **Получите начальный пароль администратора**:
   ```bash
   docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
   ```
   Или если используете docker-compose:
   ```bash
   docker-compose exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
   ```

3. **Вставьте пароль** в поле на странице Jenkins

4. **Установите рекомендуемые плагины** (или выберите нужные вручную)

5. **Создайте администратора**:
   - Username: `admin` (или ваш выбор)
   - Password: (придумайте надежный пароль)
   - Email: ваш email

6. **Настройте URL Jenkins** (обычно можно оставить по умолчанию)

## Шаг 3: Установка необходимых плагинов

После первого входа установите следующие плагины:

1. Перейдите в **Manage Jenkins** → **Manage Plugins** → **Available**

2. Найдите и установите:
   - **Maven Integration** - для работы с Maven проектами
   - **Pipeline** - для использования Jenkinsfile
   - **Git** - для работы с Git репозиториями
   - **Allure** - для генерации отчетов Allure
   - **Docker Pipeline** - для работы с Docker в pipeline
   - **Blue Ocean** (опционально) - современный UI для Jenkins

3. Нажмите **Install without restart** или **Download now and install after restart**

## Шаг 4: Настройка инструментов

1. Перейдите в **Manage Jenkins** → **Global Tool Configuration**

2. **Настройте JDK**:
   - Name: `JDK-17`
   - JAVA_HOME: `/usr/lib/jvm/java-17-openjdk-amd64` (или путь к вашей JDK)
   - Или выберите **Install automatically** и укажите версию

3. **Настройте Maven**:
   - Name: `Maven-3.9.0`
   - Выберите **Install automatically** и версию Maven 3.9.0
   - Или укажите путь к установленному Maven

## Шаг 5: Создание первого Pipeline Job

### Вариант 1: Использование Jenkinsfile (рекомендуется)

1. Перейдите в **New Item**
2. Введите имя проекта (например, `TeamProject-324`)
3. Выберите **Pipeline**
4. Нажмите **OK**

5. В разделе **Pipeline**:
   - Definition: **Pipeline script from SCM**
   - SCM: **Git**
   - Repository URL: путь к вашему Git репозиторию (или оставьте пустым для локального)
   - Script Path: `Jenkinsfile`
   - Branch: `*/Prokofev` (или ваша ветка)

6. Нажмите **Save**

7. Нажмите **Build Now** для запуска pipeline

### Вариант 2: Создание Freestyle Project

1. Перейдите в **New Item**
2. Введите имя проекта
3. Выберите **Freestyle project**
4. Нажмите **OK**

5. Настройте проект:
   - **Source Code Management**: Git (укажите URL репозитория)
   - **Build**: Add build step → **Invoke top-level Maven targets**
     - Maven Version: выберите настроенный Maven
     - Goals: `clean test package`

6. Нажмите **Save** и **Build Now**

## Шаг 6: Просмотр результатов

1. После выполнения сборки перейдите в **Build History**
2. Нажмите на номер сборки
3. Выберите **Console Output** для просмотра логов
4. Выберите **Test Result** для просмотра результатов тестов
5. Если установлен Allure, будет доступен раздел **Allure Report**

## Полезные команды Docker

```bash
# Остановить Jenkins
docker-compose stop

# Запустить Jenkins
docker-compose start

# Перезапустить Jenkins
docker-compose restart

# Просмотр логов
docker-compose logs -f jenkins

# Остановить и удалить контейнер (данные сохранятся в volume)
docker-compose down

# Полная очистка (удалит все данные!)
docker-compose down -v

# Войти в контейнер Jenkins
docker-compose exec jenkins bash
```

## Структура проекта

- `docker-compose.yml` - конфигурация Docker Compose для Jenkins
- `Jenkinsfile` - определение CI/CD pipeline для проекта
- `.dockerignore` - файлы, исключаемые из Docker контекста

## Решение проблем

### Jenkins не запускается
- Проверьте, что порт 8080 свободен: `lsof -i :8080`
- Проверьте логи: `docker-compose logs jenkins`

### Проблемы с правами доступа
- Убедитесь, что Docker socket доступен: `ls -la /var/run/docker.sock`

### Maven не найден
- Проверьте настройки в **Global Tool Configuration**
- Убедитесь, что плагин Maven Integration установлен

## Дополнительные ресурсы

- [Официальная документация Jenkins](https://www.jenkins.io/doc/)
- [Jenkins Docker образ](https://hub.docker.com/r/jenkins/jenkins)
- [Pipeline синтаксис](https://www.jenkins.io/doc/book/pipeline/syntax/)

---

**Примечание**: Данные Jenkins сохраняются в Docker volume `jenkins_home`, поэтому они не будут потеряны при перезапуске контейнера.

