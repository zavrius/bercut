1. 
Docker version 27.4.0, build bde2b89
docker network create karavan
docker run -it --rm --name karavan --network karavan -p 51336:8080 ghcr.io/apache/camel-karavan:latest
http://localhost:51336/

2. 
Финальный скрипт 
PS C:\DOCS\LAB\Bercut> camel run .\unzip-route10.yaml --reload --dep=org.example:modifycsv:1.0

Установил JBang что бы установить Camel
jbang app install camel@apache/camel
camel --version
4.10.0

3.
Когда началось задание с CSV начался процесс с java 
Установил Maven
Скачивал с https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.zip
Распаковал его в c:\DOCS\LAB\Bercut\maven
команду mvn добавлял в переменные Windows через sysdm.cpl


Установил Java 17 через JBang 

Компиляция, упаковка и установка ModifyCsvProcessor в Maven repository
javac -cp "lib/camel-api-4.10.0.jar;lib/camel-core-4.10.0.jar;." -d . ModifyCsvProcessor.java
jar cf ModifyCsvProcessor.jar -C . org/example/ModifyCsvProcessor.class
mvn install:install-file -Dfile=C:\DOCS\LAB\Bercut\ModifyCsvProcessor.jar -DgroupId=org.example -DartifactId=modifycsv -Dversion=1.0 -Dpackaging=jar -DgeneratePom=true

На эту историю ушло больше всего времени. 

4.
Финальный запуск
PS C:\DOCS\LAB\Bercut> camel run .\unzip-route10.yaml --reload --dep=org.example:modifycsv:1.0

5.
Файлы YAML я выложил на GitHub
https://github.com/zavrius/bercut
