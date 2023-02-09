# Educad plataforma educacional

## Passos para iniciar a aplicação

Com o maven instalado na máquina execute o comando a seguir na raiz do projeto
```maven
mvn clean package -DskipTests
```

Em seguida execute o comando de build do docker na raiz do projeto
```Docker
docker build --platform linux/amd64 -t educad .
```

por fim, para rodar execute o seguinte comando
```Docker
docker run --name educad -p8080:8080 educad .
```

O projeto estará disponível para uso na portal 8080