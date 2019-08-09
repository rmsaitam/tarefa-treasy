# tarefa-treasy

**Premissas:** Ter o Docker e Docker Composer instalados

Motivo: O banco de dados está em container do Docker com a imagem MySQL 5.7

Clonar o repositório

Executar o `docker-compose up -d` para o build do container MySQL

Verificar o IP do container MySQL

`docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' mysql_treasy`

Compare o resultado no arquivo _resources/application.properties_ na linha 2, provavelmente esta diferente, então substituir pelo resultado obtido.

Executar `mvn clean install`

Utilize o Postman para testar as rotas

http://localhost:8080 

**Rotas:**

`/nodes` para listar todos os nós

`/node` para inserir um novo nó

`/node/{id}` substituir o `{id}` pelo correspondente para exibir, editar ou excluir um nó específico.

