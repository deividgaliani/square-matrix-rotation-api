<h1 align="center"> Rotação de Matriz Quadrada </h1>

## Funcionalidades do projeto
- Rotacionar os dados de uma matriz, com dados enviados em uma lista, retornando os dados em uma lista

## Para rodar a aplicação
mvn spring-boot:run

## Documentação 
Swagger URL: http://localhost:8080/swagger-ui.html  

## Exemplo chamada ao endpoint
curl --request POST \  
  --url http://localhost:8080/rotate/ \  
  --header 'Content-Type: application/json' \  
  --data '{  
	"numbers": [ 1, 2, 3, 4, 5, 6, 7, 8, 9]  
}'  

## Testes unitários
Aplicação contém 2 testes unitários utilizando JUnit para os cenários de sucesso e erro  
Executar os teste utilizado JUnit  