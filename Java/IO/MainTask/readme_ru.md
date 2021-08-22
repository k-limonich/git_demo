# Main Task

Реализовать программу, которая будет получать в качестве аргумента командной строки путь к директории, например "D:/movies". Записать в текстовый файл структуру папок и файлов в виде, похожем на выполнение программы tree /F. Пример:

Amon Amarth\
|-----2004 - Fate Of Norns\
|       01 - An Ancient Sign Of Coming Storm.mp3\
|       02 - Where Death Seems To Dwell.mp3\
|       03 - The Fate Of Norns.mp3\
|       04 - The Pursuit Of Vikings.mp3\
|       05 - Valkyries Ride.mp3\
|       06 - The Beheading Of A King.mp3\
|       07 - Arson.mp3\
|       08 - Once Sealed In Blood.mp3\
|\
|-----2016 - Jomsviking\
|       01 First Kill.mp3\
|       02 Wanderer.mp3\
|       03 On A Sea Of Blood.mp3\
|       04 One Against All.mp3\
|       05 Raise Your Horns.mp3\
|       06 The Way Of Vikings.mp3\
|       07 At Dawn’s First Light.mp3\
|       08 One Thousand Burning Arrows.mp3\
|       09 Vengeance Is My Name.mp3\
|       10 A Dream That Cannot Be (feat. Doro Pesch).mp3\
|       11 Back On Northern Shores.mp3\
|       12 Death In Fire 2016.mp3\
|       13 Death In Fire (Live).mp3

Если в качестве параметра в программу передается не путь к директории, а путь к txt файлу по образцу выше - прочитать файл и вывести в консоль следующие данные:

- Количество папок
- Количество файлов
- Среднее количество файлов в папке
- Среднюю длину названия файла