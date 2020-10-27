# Spring Boot Microservices

### Descrição do Projeto

Esse projeto tem como objetivo inicial demonstrar o uso das tecnologias Spring Boot, Spring Cloud, Docker, RabbitMQ, Eureka Discovery, Zuul Gateway, Spring Security, Token JWT, Spring Web, MySQL, Lombok, Hibernate e Gradle Project.

## Informações relacionadas a IDE utilizada.
Neste projeto usei a IDE "IntelliJ" Versão: 2020.2.2 Build: 202.7319.50

## Como replicar o projeto em meu ambiente de execução?
Faça o download do projeto e abra os microserviços na IDE "IntelliJ IDEA"

#### Instale o Docker 
Vamos subir o docker composer com alguns serviços que facilitam nosso desenvolvimento, alguns serviços que vamos usar junto ao docker como o RabbitMQ serviço de mensageria e o banco de dados MySQL e o phpMyAdmin interface visual feita em php para poder adiministar o MySQL

Copie o arquivo docker-compose.yaml, abra o CMD ou Git Bash o que for da sua preferencia e va ate o repositorio onde esta o arquivo docker-compose.yaml 

Digite <strong> docker-compose up </strong> para start estes serviços e ele mesmo vai fazer a configuração.

Docker Rodando acesse a url enderço ip da sua maquina e 9090 para abrir o link de acesso ao phpMimAdmin 

Crie os banco de dados insert, order...

### Diagrama 

Onde vamos ter 3 microserviços um de insert, order e de Logon e cada um tem sua base de dados, temos tambem um service registry onde cada microserviço se conecta ao service registry e se registra no mesmo, para a comunicação entre microserviços vamos utilizar um service brocker sendo o RabbitMQ

Vamos ter uma API GATEWAY que atraves dela vamos nos comunicar aos microserviços, temos um cliente que solicita um serviço a API Gateway e a mesma leva ao serviço especifico sendo o insert o  microserviço de insert envia isso pra o service broker e com o RabbitMQ  comunica isso para o serviço de logon saber sobre este novo cadastro e para autenticar os novos clientes.

![exemplo](https://github.com/TalissonMelo/spring-boot-microservices-docker/blob/master/microservice-img/project.jpg)

## API Gateway 

E uma aplicação que se registra no service registry, ela recebe uma notificação do cliente como por exemplo fazer um cadastro de cliente.
A mesma verifica em qual microservice ela tem que ir atraves do service registry que vai passar o servidor, porta, caminho e o endereço IP do microservice desejado, e encaminha a requisição ao microservice de endpoint correto. 

API GATEWAY faz com que o cliente nao consiga acessar diretamente nenhum microservice. 

![exemplo](https://github.com/TalissonMelo/spring-boot-microservices-docker/blob/master/microservice-img/api-gateway.jpg)

## Service Discovery

O Service Discovery é um dos principais princípios da arquitetura baseada em microservices. Imagine que temos muitos serviços dinamicamente distribuídos na rede. Onde as instâncias de serviços mudam dinamicamente devido a escala automática, falhas, atualizações e não temos controle de endereços IP e nem o nome da instância.

O ideal nessa situação seria que o serviço comunica-se ao servidor ou até mesmo a algum serviço que poderia chamá-lo que está disponível para ser requisitado.

![exemplo](https://github.com/TalissonMelo/spring-boot-microservices-docker/blob/master/microservice-img/service-registry.jpg)

## Service Broker 

O Service Broker fornece enfileiramento e mensagens confiáveis para as requisições e respostas a mesma ajuda os desenvolvedores a compor aplicativos de componentes independentes denominados serviços. Os aplicativos que exigem a funcionalidade exposta nesses serviços usam mensagens para interagir com os serviços.

O Service Broker usa TCP/IP para trocar mensagens entre instâncias. O Service Broker contém recursos para ajudar a impedir o acesso não autorizado da rede e para criptografar mensagens enviadas pela rede usa a comunicação assíncrona você envia a mensagem e acabo, caso o destinaria esteja indisponível o RabbitMQ guarda a mensagem e quando o service estiver disponível ele entrega a mensagem como no exemplo abaixo.

![exemplo](https://github.com/TalissonMelo/spring-boot-microservices-docker/blob/master/microservice-img/service-broker.jpg)

#### Desmistificando o Spring Cloud Netflix. 

#### Disponível em: <https://www.infoq.com/br/articles/desmistificando-spring-cloud-netflix/>. 

#### Acesso em: 24, out. 2020.
