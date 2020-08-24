# RegisterApp

Objetivo era criar um App de Cadastro que salva dados pessoais, e que estes sejam armazenados localmente em um banco de dados.

### Para buildar o projeto é necessário:

* Android Studio
* Java 8 (mínimo)
* Android Sdk 21 (mínimo)
* Gradle 6.1.1 (mínimo)

## Funcionalidades:

* Lista de Cadastros contendo em cada Card: Nome, Idade, Localidade e Número de telefone.

* Ao digitar o CEP, corretamente, o app auto preenche as informações de endereço apropriadas.

* Inclusao(1*), Alteração(2*) e Remoção(3*) de cadastros.

   1 -Para Incluir novo cadastro:

      Click no FloatingActionButton na tela de Lista de Cadastro

   2 - Para Alterar novo cadastro:

      Click no Card da Lista de Cadastro

   3 - Para Remover novo cadastro:

      LongClick no Card da Lista de Cadastro


## Arquitetura utilizada MVP

O padrão de Arquitetura utilizado é o MVP, acrônimo para Movel-View-Presenter, esta arquitetura é uma derivação da MVC(Model-View-Controller). No MVP, o Presenter assume o papel do _intermediário_, é onde ocorre também grande parte da lógica de negócio da aplicação.

* **View**: como no MVC, responde a saída e entrada de dados, porém a saída vem do Presenter, a entrada normalmente vem do usuário.
  
* **Presenter**: Camada responsável por responder as invocações da camada de visualização e invocações da camada de modelo, além de também poder invocar ambas as camadas. O Presenter trabalha a formatação dos dados que entram em ambas as camadas paralelas e também pode incluir parte da lógica de negócio que alguns programadores podem pensar que deveria estar somente na camada de modelo.

* **Model**: Camada fornecedora de dados além de conter a lógica de negócio do domínio do problema.

[Referência](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter "Referencia Wikipedia sobre MVP")


## Data Persistence Utilizado Room

Room é uma bibliotea de Persistencia de Dados que fornece uma camada de abstração sobre o SQLite para permitir um acesso mais robusto ao banco de dados enquanto aproveita todo o poder do SQLite.

versão: 2.2.5

[Referência](https://developer.android.com/topic/libraries/architecture/room "Documentação Room - developers.android.com/")


## API para Buscar Cep: viaCep

viaCep é um _webservice_ gratuito e de alto desempenho para consultar Códigos de Endereçamento Postal do Brasil.

[Referência](https://viacep.com.br/ "Site Oficial do viaCEP")


## HTTP Client utilizado Retrofit

O Retrofit é um type-safe HTPP Client para Android e Java desenvoldido pela [Square](https://square.github.io/)

versão: 2.9.0

[Referência](https://square.github.io/retrofit/ "Documentação Retrofit - square.github.io/")

---
