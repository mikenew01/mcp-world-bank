# Bem-vindo ao MCP WorlBank API 

Serviço responsável por consultar informações de indicadores e paises das APIs do World Bank

#Desafio
O Banco Mundial https://www.worldbank.org/ mantém uma série de indicadores econômicos, disponibilizados web, arquivos para download, e APIs.
Um desses dados é o indicador que avalia a quantidade de pessoas em situação de extrema pobreza no mundo, vivendo com até $ 1,90/dia.
Este desafio consiste em construir uma aplicação que apresente os indicadores de determinado país (um voz vez), ordenados por ano. 
A aplicação deve permitir que o usuário digite o código do país para em seguida solicitar os índices históricos. Ou seja, quando o usuário entrar no sistema, irá visualizar um formulário, após o preenchimento e submissão desse, será apresentada uma tabela com o resultado obtido da API do Banco Mundial.

- [X] Backend - API Rest
- [ ] Frontend

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
$ cd mcp-world-bank
```

### Passo 3
Entre na pasta do backend 

```shell script
$ cd backend
```

### Passo 4 
Executar o comando do maven para gerar o artefato que será publicado no docker

```shell script
$ cd mvn clean install
```

### Passo 5
Voltar para pasta raiz

```shell script
$ cd ..
```

### Passo 6
Execute o comando para levantar toda infraestrutura necessária

```shell script
$ docker-compose up --build
```

Acompanhar logs: 
```shell script
$ docker-compose logs -f
```

### OU
Execute o projeto com comando do quarkus dentro da pasta do backend

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
http://localhost:8080/api/v1/paises
```
**Parametrôs:**

Parâmetro | Obrigatorio | Formato | Tipo | Descrição | Exemplo
--- | --- | --- | --- | --- | ---  
paginaAtual | Opcional  | X  | number  | Número da página para exibição | 2
porPagina | Opcional | X | number | Número de itens por página | 50 

**Curl:**
```shell script
curl -X GET "http://localhost:8080/api/v1/paises?paginaAtual=1&porPagina=50" -H  "accept: */*"
```

**Retorno:**
``` json
{
  "code": "200",
  "data": {
    "paginacao": {
      "paginaAtual": 1,
      "quantidadePaginas": 7,
      "total": 304,
      "porPagina": 50
    },
    "paises": [
      {
        "codigoPais": "ABW",
        "nome": "Aruba",
        "capital": "Oranjestad"
      },
      {
        "codigoPais": "AFG",
        "nome": "Afghanistan",
        "capital": "Kabul"
      },
      {
        "codigoPais": "AFR",
        "nome": "Africa",
        "capital": ""
      }
    ]
   },
   "erro": null 
}
```
---

## /api/v1/indicators/{id}
**Url de requisição:**
```
http://localhost:8080/api/v1/indicadores/ABW
```
**Parametrôs Query:**

Parâmetro | Obrigatorio |Formato | Tipo | Descrição | Exemplo
--- | --- | --- | --- | --- | ---  
codigoPais | Obrigatorio | XXX | string | Código do pais | ABW
paginaAtual | Opcional  | X  | number  | Número da página para exibição | 2
porPagina | Opcional | X | number | Número de itens por página | 50 


**Curl:**
```shell script
curl -X GET "http://localhost:8080/api/v1/indicadores/ABW?paginaAtual=1&porPagina=50" -H  "accept: */*"
```

**Retorno:**
``` json
{
  "code": "200",
  "data": {
    "paginacao": {
      "paginaAtual": 1,
      "quantidadePaginas": 2,
      "total": 61,
      "porPagina": 50
    },
    "indicadores": [
      {
        "dataAno": 1971,
        "codigoPais": "ABW",
        "nomePais": "Aruba",
        "indicador": "Poverty headcount ratio at $1.90 a day (2011 PPP) (% of population)",
        "codigoIndicador": "SI.POV.DDAY"
      },
      {
        "dataAno": 1972,
        "codigoPais": "ABW",
        "nomePais": "Aruba",
        "indicador": "Poverty headcount ratio at $1.90 a day (2011 PPP) (% of population)",
        "codigoIndicador": "SI.POV.DDAY"
      }
      ]
    },
  "erro": null 
}
```
---
