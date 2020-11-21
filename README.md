# Bem-vindo ao MCP WorlBank API :money_with_wings:

Serviço responsável por consultar informações de indicadores e paises das APIs do World Bank

# Introdução Arquitetura 
Durante o desenvolvimento foram tomadas algumas decisões com relação a tecnologias usadas. O backend foi desenvolvido utilizando o framework 
[Quarkus](https://quarkus.io/) por questões de produtividade e desempenho em relação a outras arquiteturas.

Algumas ferramentas foram adicionadas para monitoração e logs na aplicação, dentre elas: [Prometheus](https://quarkus.io/guides/microprofile-metrics), [Jaeger](https://quarkus.io/guides/opentracing), 
[Elasticsearh](https://quarkus.io/guides/centralized-log-management), [Logstash](https://quarkus.io/guides/centralized-log-management), [Grafana](https://www.katacoda.com/openshift/courses/middleware/middleware-quarkus/monitoring) e [Kibana](https://quarkus.io/guides/centralized-log-management). Utilizando as [integrações](https://quarkus.io/guides/) que o quarkus oferece. 

Aplicação foi pensada para ser resiliente e tolerante a falhas. 

---
**Observação: O projeto foi desenvolvido utilizando o Windows e por isso algumas configurações no docker/docker-compose podem ser diferentes 
para cada sistema operacional. O Docker do Windows não possui suporte ao modo 'host' na criação de rede entre containers e por isso 
foi utilizado em alguns casos a propriedade 'host.docker.internal' para contornar esse problema.** 

---

# Ferramentas complementares

Ferramenta | Descrição
--- | ---
[Prometheus](https://quarkus.io/guides/microprofile-metrics) | Sistema de monitoramento para analise de metricas das aplicações
[Jaeger](https://quarkus.io/guides/opentracing) | Sistema de rastramento para requisições
[ELK](https://quarkus.io/guides/centralized-log-management)| Sistema centralizador de logs. Elasticsearch, Logstash e Kibana
[Quarkus](https://quarkus.io/) | Framework utilizado para criar o backend
[Grafana](https://www.katacoda.com/openshift/courses/middleware/middleware-quarkus/monitoring) | Sistema de monitoramento e dashboards

# Ambiente de desenvolvimento

Existem alguns passos para execução do projeto em ambiente local, necessário que alguns programas estejam corretamente instalados.

Framework/lib | Versão Recomendada | S.O Utilizado
--- | --- | ---
[Maven](https://maven.apache.org/download.cgi) | 3.6.3 | Windows
[JDK](https://openjdk.java.net/projects/jdk/11/) | 11 | Windows
[Docker](https://docs.docker.com/docker-for-windows/install/) | 19.03.13 | Windows
[Docker Compose](https://docs.docker.com/compose/install/) | 1.27.4 | Windows
[Intellij](https://www.jetbrains.com/pt-br/idea/)| - | Windows

## Execução do projeto 

### Passo 1
Faça o clone do projeto
```shell script
$ git clone https://github.com/Maikoncanuto/mcp-world-bank.git mcp-world-bank
```

### Passo 2 
Entre na pasta raiz do projeto

```shell script
$ cd mcp-quote
```

### Passo 3
Execute o comando para levantar toda infraestrutura necessária

```shell script
$ docker-compose up 
```

Acompanhar logs: 
```shell script
$ docker-compose logs -f
```

### Passo 4
Execute o comando para instalar as dependências necessárias

```shell script
$ mvn clean package 
```

### Passo 5
Execute o projeto com comando do quarkus

```shell script
$ ./mvnw compile quarkus:dev
```

ou 

```shell script
java -jar target/worldbank-0.0.1-SNAPSHOT-runner.jar
```

# Serviços do mcp-quote-api

Serviço | URL | Status | Descrição
--- | --- | --- | ---
Swagger | http://localhost:8080/swagger-ui/#/ | :white_check_mark: | Informação dos endpoints na aplicação
Health Live | http://localhost:8080/health/live | :white_check_mark: | Responsável por identificar a sáude da aplicação
Health Ready | http://localhost:8080/health/ready | :white_check_mark: | Responsável por identificar se aplicação está pronta para uso
Jaeger | http://localhost:8180 | :white_check_mark: | Rastreamento de requisições
Prometheus | http://localhost:8280 | :white_check_mark: | Analise de Métricas da aplicação
Kibana | http://localhost:8380 | :white_check_mark: | Visualizar Logs 
Grafana | http://localhost:8480 | :white_check_mark: | Monitoramento e Dashboards


# Exemplo de requisições para os Endpoints

## Buscar informações de paises
**Url de requisição:**
```
http://localhost:8080/api/v1/countries
```
**Parametrôs:**

Parâmetro | Formato | Tipo | Descrição | Exemplo
--- | --- | --- | --- | ---  
Não existe | Não existe  | Não existe  | Não existe  | Não existe 

**Curl:**
```shell script
curl -X GET "http://localhost:8080/api/v1/countries" -H  "accept: */*"
```

**Retorno:**
``` json
{
  {
    "code": "200",
    "data": {
      "pagination": {
        "page": 1,
        "pages": 7,
        "total": 304,
        "per_page": "50"
      },
    "countries": [
        {
          "id": "ABW",
          "iso2Code": "AW",
          "name": "Aruba",
          "region": null,
          "incomeLevel": null,
          "lendingType": null,
          "capitalCity": "Oranjestad",
          "longitude": "-70.0167",
          "latitude": "12.5167",
          "adminregion": null
        },
        {
          "id": "AFG",
          "iso2Code": "AF",
          "name": "Afghanistan",
          "region": null,
          "incomeLevel": null,
          "lendingType": null,
          "capitalCity": "Kabul",
          "longitude": "69.1761",
          "latitude": "34.5228",
          "adminregion": null
        }
    ],
    "erro": null 
}
```
---

## /api/v1/indicators/{id}
**Url de requisição:**
```
http://localhost:8080/api/v1/indicators/ABW
```
**Parametrôs Query:**

Parâmetro | Formato | Tipo | Descrição | Exemplo
--- | --- | --- | --- | ---  
id | XXX| string | Código do pais | ABW

**Curl:**
```shell script
curl -X GET "http://localhost:8080/api/v1/indicators/ABW" -H  "accept: */*"
```

**Retorno:**
``` json
{
  "code": "200",
  "data": {
    "pagination": {
      "page": 1,
      "pages": 2,
      "total": 61,
      "perPage": 50,
      "sourceId": "2",
      "lastupdated": "2020-10-15"
    },
    "indicators": [
      {
        "indicator": {
          "id": "SI.POV.DDAY",
          "value": "Poverty headcount ratio at $1.90 a day (2011 PPP) (% of population)"
        },
        "country": {
          "id": "AW",
          "value": "Aruba"
        },
        "countryIso3Code": "ABW",
        "date": "2020",
        "value": null,
        "unit": "",
        "obsStatus": "",
        "decimal": 1
      }
  ],
  "erro": null 
}
```
---
