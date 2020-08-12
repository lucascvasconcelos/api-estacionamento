# Api REST com spring boot 

## Requisitos
- JDK 1.8+;
- Maven
- postgres

## Configure sua conexão com o seu banco de dados (postgres)
```
- Basta adicionar suas credenciais do banco de dados no arquivo "application.prperties"
```

## Levantando a aplicação
```
- mvn spring-boot:run

- Pronto!! Sua aplicação estará disponível na porta 8000. ex: localhost:8000/enderecos
```

## O que foi feito...

```
- Criei uma estrutura de backend básica do servidor utilizando o estilo de 
arquitetura da API REST.
- Endpoint de listagem de vagas
- Listar posição das vagas disponíveis
- Estacionar o veículo em vaga disponível
- Pagamento do ticket
- Relatório gerencial com quantidade de veículos estacionados e somatório dos pagamentos realizados (apenas dados em formato de JSON);
- Também foi criado uma estrutura de service para tornar o controller mais limpo.
- Separei o front do projeto em outro repositório com um projeto angular onde foi implementado o client
```


![image](https://i.ibb.co/mSDGPYH/Captura-de-tela-de-2020-02-24-20-46-34.png)