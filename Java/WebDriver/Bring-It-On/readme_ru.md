### Bring It On

*При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object.*</br></br>
**Автоматизировать следующий сценарий:**
1. Открыть https://pastebin.com  или аналогичный сервис в любом браузере
2. Создать New Paste со следующими деталями:
- Код:</br></br>
git config --global user.name  "New Sheriff in Town"</br>
git reset $(git commit-tree HEAD^{tree} -m "Legacy code")</br>
git push origin master --force</br></br>
- Syntax Highlighting: "Bash"
- Paste Expiration: "10 Minutes"
- Paste Name / Title: "how to gain dominance among developers"
3. Сохранить paste и проверить следующее:
- Заголовок страницы браузера соответствует Paste Name / Title
- Синтаксис подвечен для bash
- Проверить что код соответствует введенному в пункте 2