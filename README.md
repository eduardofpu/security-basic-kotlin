# Securit-Basic-kotlin

```
Objetivo desse projeto

Contruir uma API kotlin que realiza authentication com segurança basic

```

```


```
## Requisitos
```
Java 1.8

Ter o mongodb instalado
abrir o terminal:
1 - primeira aba sudo mongod
2 - na outra aba digite apenas mongo

execute:
show databases
use security-kotlin-basic
show tables
db.usuario.find().pretty()
```

# Recursos para testar a api
```
POST    http://localhost:8080/v1/admin/register
POST  localhost:8080/v1/protected/register
```
#### Criar usuário para authenticar na api  logando como ROLE_ADMIN

```
No pacote controller alterar para   @PostMapping("/admin/register")
POST  http://localhost:8080/v1/admin/register
{
	"username":"Admin",
	"email":"teste@admin.com",
	"password":"123456",
	"admin":true
}

```
#### Insira  Usuários logando como ROLE_USER
```
No pacote controller alterar para   @PostMapping("/protected/register")
POST  localhost:8080/v1/protected/register
{
	"username":"User",
	"email":"teste@user.com",
	"password":"123456",
	"admin":null
}

Obs: admin null  é salvo como false, isso foi implementado como tratamento padrão da api será reconhecido como ROLE_USER 
se passar true será reconhecido como ROLE_ADMIN

```

