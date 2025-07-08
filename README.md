# Desafio API ViaCEP

Este repositório contém o desafio proposto para validar a funcionalidade da **API ViaCEP**. Através desse desafio, foi realizado o levantamento dos fluxos principais da API, além de identificar possíveis melhorias e escrever cenários de teste baseados em diferentes comportamentos da API.

## O que está no arquivo `desafio.md`:

### 1. **Análise Funcional da API - ViaCEP**

### 2. **Cenários de Teste em Gherkin**

### 3. **Cenário Escolhido para Automação**

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

Os resultados dos testes serão exibidos no terminal, permitindo verificar se a API está funcionando conforme esperado.

### Objetivo do Teste:
O objetivo principal do teste é garantir que a API ViaCEP retorne os dados corretos para um CEP válido.

### Resultado Esperado:
Quando o CEP "38010-270" for consultado, a API deve retornar:

Logradouro: "Rua Major Eustáquio"

Bairro: "Centro"

Cidade: "Uberaba"

## Conclusão
Este repositório contém os cenários de teste necessários para validar a API ViaCEP, desde cenários positivos até negativos, garantindo que a API funcione corretamente em diferentes condições. O código automatizado foi desenvolvido com a finalidade de facilitar a validação contínua do serviço e garantir que as funcionalidades principais estejam funcionando conforme o esperado.