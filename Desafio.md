# Análise Funcional da API - ViaCEP

A **API ViaCEP** é uma API pública utilizada para consultar informações de endereços a partir de um código de CEP. A documentação descreve como realizar as consultas e quais são as respostas esperadas. A análise dos fluxos principais e possíveis melhorias se concentra nas seguintes etapas.

## Fluxos Principais da API

### 1. Consulta de CEP Válido
- **Objetivo:** Retornar informações completas sobre o endereço associado ao CEP informado.
- **Exemplo de consulta:** `https://viacep.com.br/ws/01001000/json/`

### 2. Consulta de CEP Inválido
- **Objetivo:** Retornar erro ou resposta vazia quando o CEP informado for inválido ou não existir.
- **Exemplo de consulta:** `https://viacep.com.br/ws/99999999/json/`

### 3. Consulta de CEP com Formato Inválido
- **Objetivo:** Validar que a API rejeita consultas com formato de CEP inválido (por exemplo, letras no CEP).
- **Exemplo de consulta:** `https://viacep.com.br/ws/ABC12345/json/`

### 4. Consulta de CEP para Diferentes Tipos de Localização
- **Objetivo:** Validar que a API retorna corretamente os dados para diferentes tipos de endereços (logradouro, bairro, cidade, estado).
- **Exemplo de consulta:** `https://viacep.com.br/ws/01001000/json/`

### 5. Consulta de CEP com Código de Estado Inexistente
- **Objetivo:** Validar a resposta da API quando o código de estado (UF) informado não existir.
- **Exemplo de consulta:** `https://viacep.com.br/ws/01001000/json/`


## Melhorias Encontradas na Documentação

### 1. Documentação mais detalhada sobre erros
A documentação poderia explicar melhor as diferentes respostas de erro, como "CEP não encontrado" ou "Formato inválido", especificando os códigos de status HTTP e exemplos de resposta. Isso facilitaria a compreensão do comportamento da API em diferentes cenários de falha.

### 2. Inclusão de cache para consultas frequentes
Considerar a inclusão de uma estratégia de cache para consultas frequentes pode melhorar significativamente o desempenho da API, especialmente considerando que muitos usuários consultam os mesmos CEPs repetidamente.

### 3. Melhoria na Resposta de Múltiplos CEPs
Seria interessante permitir a consulta de múltiplos CEPs ao mesmo tempo, retornando as informações em um formato estruturado. Isso reduziria a necessidade de realizar várias consultas em sequência, melhorando a eficiência.

## Cenários de Teste em Gherkin

### 1. Consulta de CEP Válido
- **Objetivo:** Retornar informações completas sobre o endereço associado ao CEP informado.
- **Exemplo de consulta:** `https://viacep.com.br/ws/01001000/json/`

**Cenário 1: Consulta de CEP Válido**  
Objetivo: Validar que a API retorna os dados corretos ao consultar um CEP existente.
- **Dado:** Que o usuário consulta o CEP "38010-270".
- **Quando:** A API retorna os dados do endereço.
- **Então:** O logradouro deve ser "Rua Major Eustáquio", o bairro "Centro" e a cidade "Uberaba".

**Cenário 2: Consulta de CEP Válido sem o Hífen**  
Objetivo: Validar que a API aceita um CEP válido sem o hífen e retorna os dados corretos.
- **Dado:** Que o usuário consulta o CEP "38010270".
- **Quando:** A API retorna os dados do endereço.
- **Então:** O logradouro deve ser "Rua Major Eustáquio", o bairro "Centro" e a cidade "Uberaba".

**Cenário 3: Consulta de CEP com Formato Correto**  
Objetivo: Validar que a API retorna os dados corretos ao consultar um CEP com formato válido.
- **Dado:** Que o usuário consulta o CEP "38010-270".
- **Quando:** A API retorna os dados do endereço.
- **Então:** O logradouro deve ser "Rua Major Eustáquio", o bairro "Centro" e a cidade "Uberaba".

### 2. Consulta de CEP Inválido
- **Objetivo:** Retornar erro ou resposta vazia quando o CEP informado for inválido ou não existir.
- **Exemplo de consulta:** `https://viacep.com.br/ws/99999999/json/`

**Cenário 4: Consulta de CEP Inválido**  
Objetivo: Validar que a API retorna um erro ao consultar um CEP inválido.
- **Dado:** Que o usuário consulta o CEP "99999-999".
- **Quando:** A API tenta retornar os dados do endereço.
- **Então:** A API deve retornar um erro indicando que o CEP é inválido.

**Cenário 5: Consulta de CEP Não Existente**  
Objetivo: Validar que a API retorna uma mensagem de erro quando o CEP não existe.
- **Dado:** Que o usuário consulta o CEP "12345-678".
- **Quando:** A API tenta retornar os dados do endereço.
- **Então:** A API deve retornar uma mensagem indicando que o CEP não foi encontrado.

### 3. Consulta de CEP com Formato Inválido
- **Objetivo:** Validar que a API rejeita consultas com formato de CEP inválido (por exemplo, letras no CEP).
- **Exemplo de consulta:** `https://viacep.com.br/ws/ABC12345/json/`

**Cenário 6: Consulta de CEP com Formato Incorreto**  
Objetivo: Validar que a API retorna um erro ao consultar um CEP com formato incorreto.
- **Dado:** Que o usuário consulta o CEP "0100100A".
- **Quando:** A API tenta retornar os dados do endereço.
- **Então:** A API deve retornar um erro indicando que o formato do CEP é inválido.

**Cenário 7: Consulta de CEP com Formato Incorreto**  
Objetivo: Validar que a API retorna um erro ao consultar um CEP com formato incorreto.
- **Dado:** Que o usuário consulta o CEP "01001-00A".
- **Quando:** A API tenta retornar os dados do endereço.
- **Então:** A API deve retornar um erro indicando que o formato do CEP é inválido.

### 4. Consulta Sem CEP
- **Objetivo:** Validar que a API retorna um erro quando o CEP não é fornecido.
- **Exemplo de consulta:** `https://viacep.com.br/ws//json/`

**Cenário 8: Consulta Sem CEP**  
Objetivo: Validar que a API retorna um erro quando o CEP não é fornecido.
- **Dado:** Que o usuário não fornece um CEP.
- **Quando:** A API tenta realizar a consulta sem o CEP.
- **Então:** A API deve retornar um erro informando que o CEP é obrigatório.

### 5. Consulta com Caracteres Especiais
- **Objetivo:** Validar que a API retorna um erro ao consultar um CEP com caracteres especiais.
- **Exemplo de consulta:** `https://viacep.com.br/ws/01001@000/json/`

**Cenário 9: Consulta com Caracteres Especiais**  
Objetivo: Validar que a API retorna um erro ao consultar um CEP com caracteres especiais.
- **Dado:** Que o usuário consulta o CEP "01001@000".
- **Quando:** A API tenta retornar os dados do endereço.
- **Então:** A API deve retornar um erro indicando que o CEP contém caracteres especiais inválidos.

**Cenário 10: Consulta com Caracteres Especiais**  
Objetivo: Validar que a API retorna um erro ao consultar um CEP com caracteres especiais.
- **Dado:** Que o usuário consulta o CEP "01001@-000".
- **Quando:** A API tenta retornar os dados do endereço.
- **Então:** A API deve retornar um erro indicando que o CEP contém caracteres especiais inválidos.

### 6. Consulta de CEP com Número de Caracteres Incorreto
- **Objetivo:** Validar que a API retorna um erro ao consultar um CEP com número incorreto de caracteres.
- **Exemplo de consulta:** `https://viacep.com.br/ws/0100100/json/`

**Cenário 11: Consulta de CEP com Número de Caracteres Incorreto**  
Objetivo: Validar que a API retorna um erro ao consultar um CEP com número incorreto de caracteres.
- **Dado:** Que o usuário consulta o CEP "0100100".
- **Quando:** A API tenta retornar os dados do endereço.
- **Então:** A API deve retornar um erro indicando que o CEP possui número incorreto de caracteres.

### 7. Consulta de Vários CEPs Simultaneamente
- **Objetivo:** Validar que a API consegue processar múltiplas consultas simultâneas de CEPs.
- **Exemplo de consulta:** `https://viacep.com.br/ws/01001-000/json/` e `https://viacep.com.br/ws/01001-001/json/`

**Cenário 12: Consulta de Vários CEPs Simultaneamente**  
Objetivo: Validar que a API consegue processar múltiplas consultas simultâneas de CEPs.
- **Dado:** Que o usuário consulta os CEPs "01001-000" e "01001-001".
- **Quando:** A API retorna os dados de ambos os CEPs.
- **Então:** A API deve retornar o endereço correto para cada CEP.

### 8. Consulta de CEP sem Autenticação
- **Objetivo:** Validar que a API permite a consulta de CEP sem necessidade de autenticação.
- **Exemplo de consulta:** `https://viacep.com.br/ws/01001-000/json/`

**Cenário 13: Consulta de CEP sem Autenticação**  
Objetivo: Validar que a API permite a consulta de CEP sem necessidade de autenticação.
- **Dado:** Que a API não exige autenticação para consulta.
- **Quando:** O usuário consulta o CEP "01001-000" sem fornecer credenciais.
- **Então:** A API deve permitir a consulta e retornar o endereço correto.

### 9. Consulta de CEP via HTTP vs HTTPS
- **Objetivo:** Validar que a API retorna os dados corretamente tanto para o protocolo HTTP quanto HTTPS.

**Cenário 14: Consulta de CEP via HTTP**  
Objetivo: Validar que a API retorna os dados corretamente para o protocolo HTTP.
- **Dado:** Que o usuário consulta o CEP "01001-000" via HTTP.
- **Quando:** A API retorna os dados do endereço.
- **Então:** O logradouro deve ser "Praça da Sé", o bairro "Sé" e a cidade "São Paulo".

**Cenário 15: Consulta de CEP via HTTPS**  
Objetivo: Validar que a API retorna os dados corretamente para o protocolo HTTPS.
- **Dado:** Que o usuário consulta o CEP "01001-000" via HTTPS.
- **Quando:** A API retorna os dados do endereço.
- **Então:** O logradouro deve ser "Praça da Sé", o bairro "Sé" e a cidade "São Paulo".


## Cenário de teste escolhido para automação

- **Cenário Escolhido:** Consulta de CEP Válido.

**Justificativa:**
Foi escolhido o cenário acima por se tratar do fluxo principal de uso da API, com alta frequência de uso. A consulta de um CEP válido é o caso mais comum e relevante para os usuários da API, além de ser o caso que pode ser testado de forma automatizada para garantir que a API sempre retorne dados corretos e consistentes. Esse cenário é fundamental para a integridade da API, já que a maioria dos testes de API depende da correta resposta da API.
