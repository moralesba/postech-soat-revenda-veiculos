$env:JAVA_HOME="C:\Program Files\Java\jdk-17"
$env:Path="$env:JAVA_HOME\bin;$env:Path"

mvn clean install --settings C:\Users\barbara.morales\.m2\settings-pessoal.xml -DskipTests