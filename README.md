# metrics-prometheus 

Nesse código vocês vão encontrar exemplo da geração de métricas.

Os serviços foram escritos em Java usando Spring e micrometer.

As métricas podem ser vicualizadas do Prometheus e Grafana.

# Tecnologias utilizadas

* Gradle
* Spring boot
* Prometheus
* Java
* Grafana
* Docker

# Entendendo a Aplicação:

O Exemplo simula a coleta de algumas métricas em uma aplicação Spring Boot.

** Counter **
O Counter pode ser visualizado utilizando as rotas abaixo:

* Error: http://localhost:8080/teste-metric/error

* Success: http://localhost:8080/teste-metric/success

* Pending: http://localhost:8080/teste-metric/pending

![Log](./doc/images/log.jpeg)
![Prometheus](./doc/images/log_prometheus.jpeg)