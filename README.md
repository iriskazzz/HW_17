# Демо проект по автоматизации тестовых сценариев для магазина [Bork](https://www.bork.ru/)

<p align="center">
<img title="bork" src="media/logo/bork_logo.png">
</p>

## **Содержание:**

> ➠ [Технологический стек](#использованный-стек-технологий)
>
> ➠ [Покрытый функционал](#покрытый-функционал)
>
> ➠ [Запуск из терминала](#запуск-тестов-из-терминала)
> 
> ➠ [Сборка в Jenkins](#Сборка-в-Jenkins)
>
> ➠ [Allure отчет](#Пример-Allure-отчета)
>
> ➠ [Отчет в Telegram](#Уведомления-в-Telegram-с-использованием-бота)
>
> ➠ [Видео примеры прохождения тестов](#Видео-примера-запуска-тестов-в-Selenoid)

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

В данном проекте автотесты написаны на <code>Java</code> с использованием <code>Selenide</code> для UI-тестов

#### Реализованы паттерны PageObject и Lambda Steps
>
> <code>Selenoid</code> выполняет запуск браузеров в контейнерах <code>Docker</code>
>
> <code>Allure Report</code> формирует отчеты о запуске тестов
>
> Для автоматизированной сборки проекта используется <code>Gradle</code>
>
> В качестве библиотеки для модульного тестирования используется <code>JUnit 5</code>
>
> <code>Jenkins</code> выполняет запуск тестов
> 
> После завершения прогона отправляются уведомления с помощью бота в <code>Telegram</code>


## Покрытый функционал

- [x] Проверка отображения карты и списка бутиков
- [x] Проверка открытия раздела и подраздела с карточками товаров
- [x] Проверка добавления товара в корзину
- [x] Проверка удаления товара из корзины
- [x] Проверка работы поисковика
- [x] Проверка смены языка
- [x] Проверка открытия страницы рецепта

## Запуск тестов из терминала

### Локальный запуск
```
gradle clean test
```

### Удаленный запуск тестов на Jenkins

```
clean
testByTags
-Dtags=${TAG}
-DbrowserName=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DremoteUrl=${REMOTE_URL}
-Denv=remote
```
При выполнении команды, данные тесты запустятся удаленно в <code>Selenoid</code>.

При необходимости также можно переопределить параметры запуска

### Параметры сборки

* <code>TAG</code> – тэг с которым будут запускаться тесты.
* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>.
* <code>BROWSER_VERSION</code> - версия браузера. По-умолчанию - <code>100.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера. По-умолчанию - <code>1920x1080</code>.
* <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.

## [Сборка в Jenkins](https://jenkins.autotests.cloud/job/zolina_dimplom_ui/)
<p align="center">
<img title="Jenkins Build" src="media/screens/JenkinsBuild.png">
</p>

## [Пример Allure-отчета](https://jenkins.autotests.cloud/job/zolina_dimplom_ui/allure)
### Overview

<p align="center">
<img title="Allure Overview" src="media/screens/allureReport.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="media/screens/ResultTest.png">
</p>

## Уведомления в Telegram с использованием бота

> После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/notification.png">
</p>

## Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/screens/video.gif">
</p>