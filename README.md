# Демо проект по автоматизации тестовых сценариев для магазина [Bork](https://www.bork.ru/)

## **Содержание:**

- [Использованный стек технологий](#использованный-стек-технологий)
- [Запуск автотестов](#запуск-автотестов)
- [Сборка в Jenkins](#Сборка-в-Jenkins)
- [Пример Allure-отчета](#Пример-Allure-отчета)
- [Уведомления в Telegram с использованием бота](#Уведомления-в-Telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#Видео-примера-запуска-тестов-в-Selenoid)

## Использованный стек технологий

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg">
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/logo/Java.svg">
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/logo/Selenide.svg">
<a href="https://selenoid.autotests.cloud/"><img width="6%" title="Selenoid" src="media/logo/Selenoid.svg">
<a href="https://allurereport.org/"><img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg">
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/logo/Gradle.svg">
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/logo/JUnit5.svg">
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/logo/GitHub.svg">
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/logo/Jenkins.svg">
<a href="https://web.telegram.org/"><img width="6%" title="Telegram" src="media/logo/Telegram.svg">
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка Selenide для тестирования.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в [Jenkins](https://jenkins.autotests.cloud/job/MyProject58/) с формированием [Allure-отчета](https://jenkins.autotests.cloud/job/MyProject58/7/allure/) и отправкой результатов в <code>Telegram</code> при помощи бота.

## Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## Запуск автотестов

### Запуск тестов из терминала
```
gradle clean test
```
При выполнении команды, данные тесты запустятся удаленно в <code>Selenoid</code>.

При необходимости также можно переопределить параметры запуска

```
clean testByTags 
-Dtags=${TAG} 
-DbrowserName=${BROWSER}
-DbrowserSize=${BROWSER_SIZE}
-DremoteUrl=${REMOTE_URL}
```

### Параметры сборки

* <code>TAG</code> – тэг с которым будут запускаться тесты.
* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты.
* <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.

## Сборка в Jenkins
<p align="center">
<img title="Jenkins Build" src="media/screens/JenkinsBuild.png">
</p>

## Пример Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="media/screens/allureReport.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="media/screens/ResultTest.png">
</p>

## Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/notification.png">
</p>

## Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/screens/video.gif">
</p>