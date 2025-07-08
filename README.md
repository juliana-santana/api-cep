# Desafio API ViaCEP

Este repositório contém o desafio proposto para validar a funcionalidade da **API ViaCEP**. Através desse desafio, foi realizado o levantamento dos fluxos principais da API, além de identificar possíveis melhorias e escrever cenários de teste baseados em diferentes comportamentos da API.

# Fluxo do Teste - Consulta de CEP Válido

Este teste valida se a **API ViaCEP** retorna corretamente os dados associados a um CEP válido. O CEP utilizado para o teste é **38010-270**, que corresponde a um endereço real.

## Fluxo do Teste

### 1. **Configuração de Parâmetros**

O teste começa configurando as constantes necessárias:
- **BASE_URL**: A URL base da API (`https://viacep.com.br`).
- **CEP_PATH**: O caminho do endpoint para consulta do CEP (`/ws/{cep}/json/`).
- **CEP**: O valor do CEP que será consultado (`38010-270`).

### 2. **Configuração da Requisição**

A requisição é configurada utilizando a biblioteca **RestAssured**:
- A URL base e o caminho são definidos.
- O **CEP** é substituído no caminho da URL.
- A requisição **GET** é enviada para o serviço ViaCEP.

   ```bash
   Response response = RestAssured.given()
   .baseUri(BASE_URL)              // Define a base URL (viacep.com.br)
   .basePath(CEP_PATH)             // Define o caminho para consulta do CEP
   .pathParam("cep", CEP)         // Substitui {cep} pelo valor de CEP ("38010-270")
   .when()
   .get()                          // Envia a requisição GET
   .then()
   .extract()                      // Extrai a resposta
   .response()                     // Armazena a resposta
   .prettyPeek();                  // Exibe a resposta de forma legível no console

### 3. Validação do Código de Status

- O código de status da resposta é validado para garantir que a requisição foi bem-sucedida. O esperado é que a resposta tenha o código de status 200 OK:

   ```bash
   assertEquals(200, response.getStatusCode());

### 4. Extração dos Dados do JSON

- A resposta da API é extraída no formato JSON, e os campos de interesse são acessados:


- logradouro: A rua associada ao CEP.
- bairro: O bairro associado ao CEP.
- localidade: A cidade associada ao CEP.

   ```bash
   String logradouro = response.jsonPath().getString("logradouro");
   String bairro = response.jsonPath().getString("bairro");
   String cidade = response.jsonPath().getString("localidade");

### 5. Verificação dos Valores Extraídos

- O teste verifica se os valores extraídos correspondem aos dados esperados para o CEP 38010-270. Os valores esperados são:

- logradouro: "Rua Major Eustáquio"
- bairro: "Centro"
- cidade: "Uberaba"

   ```bash
   assertEquals("Rua Major Eustáquio", logradouro);
   assertEquals("Centro", bairro);
   assertEquals("Uberaba", cidade);



## **Instruções para Rodar o Código Automatizado**

Abaixo estão as instruções para rodar o código automatizado desenvolvido para testar a API ViaCEP:

#### Pré-requisitos:
- **Java 8 ou superior**: Necessário para executar os testes automatizados.
- **Maven ou Gradle**: Para gerenciamento de dependências.
- **IDE como IntelliJ IDEA ou Eclipse** (opcional, mas recomendado).

#### Instalação:
1. Clone o repositório do código:
   ```bash
   git clone https://github.com/juliana-santana/api-cep.git
   cd api-cep

2. No terminal, navegue até a pasta do projeto.


3. Execute o comando para instalar as dependências:   
   ```bash
   mvn clean install

4. Execute os testes com o comando:
   ```bash
   mvn test

## Abrir o Projeto no IntelliJ IDEA:

1. Abra o IntelliJ IDEA.

2. Abra o Projeto:
- Selecione a opção Open. Navegue até o diretório onde o projeto foi baixado e clique em OK.

3. Verifique as dependências e configuração:

- Verifique o arquivo pom.xml

- Abra o pom.xml no IntelliJ IDEA. A IDE deve reconhecer automaticamente o projeto como Maven. Caso contrário, clique com o botão direito no pom.xml e selecione Add as Maven Project.

4. Rode os Testes:

- Navegue até a classe de teste e clique com o botão direito sobre ela. Selecione Run 'ViaCEPTest' para rodar os testes dessa classe.

Os resultados dos testes serão exibidos no terminal, permitindo verificar se a API está funcionando conforme esperado.

### Objetivo do Teste:
O objetivo principal do teste é garantir que a API ViaCEP retorne os dados corretos para um CEP válido.

### Resultado Esperado:
Quando o CEP "38010-270" for consultado, a API deve retornar:

Logradouro: "Rua Major Eustáquio"

Bairro: "Centro"

Cidade: "Uberaba"


## O que está no arquivo `AnáliseFuncionalDaAPI.md`:

### 1. **Análise Funcional da API - ViaCEP**

## O que está no arquivo `CenáriosDeTesteEscritos.md`:

### 1. **Cenários de Teste em Gherkin**

### 2. **Cenário Escolhido para Automação e Justificativa**


## Conclusão
Este repositório contém os cenários de teste necessários para validar a API ViaCEP, desde cenários positivos até negativos, garantindo que a API funcione corretamente em diferentes condições. O código automatizado foi desenvolvido com a finalidade de facilitar a validação contínua do serviço e garantir que as funcionalidades principais estejam funcionando conforme o esperado.

