## Cenários de Teste Escritos

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


# 10. Cenários de Teste para Pesquisa de Endereço (ViaCEP)

**Cenário 15: Pesquisa por Endereço com Parâmetros Válidos e Retorno no Formato JSON
Objetivo: Validar que a API retorna os dados corretos ao consultar o CEP com parâmetros válidos (UF, Cidade, Logradouro) e o formato JSON.

**Dado**:  
Que o usuário consulta os parâmetros obrigatórios:
- UF: "RS"
- Cidade: "Porto Alegre"
- Logradouro: "Domingos"
- Formato: "json"

**Quando**:  
A API é consultada com a URL `viacep.com.br/ws/RS/Porto+Alegre/Domingos/json/`

**Então**:  
O código de resposta da API deve ser 200 (OK).  
A resposta deve estar no formato JSON.  
A lista de CEPs retornados deve estar ordenada pela proximidade do nome do logradouro.  
O número máximo de CEPs retornados deve ser 50.

---

**Cenário 16: Pesquisa por Endereço com Logradouro Parcial
Objetivo: Validar que a API retorna os dados corretos mesmo com um logradouro parcialmente informado.

**Dado**:  
Que o usuário consulta os parâmetros obrigatórios:
- UF: "RS"
- Cidade: "Porto Alegre"
- Logradouro: "Domingos Jose"
- Formato: "json"

**Quando**:  
A API é consultada com a URL `viacep.com.br/ws/RS/Porto+Alegre/Domingos+Jose/json/`

**Então**:  
O código de resposta da API deve ser 200 (OK).  
A resposta deve estar no formato JSON.  
A lista de CEPs retornados deve estar ordenada pela proximidade do nome do logradouro.  
O número máximo de CEPs retornados deve ser 50.

---

**Cenário 17: Pesquisa com Nome de Logradouro Menor que 3 Caracteres (Bad Request)
Objetivo: Validar que a API retorna um código de erro 400 caso o logradouro tenha menos de 3 caracteres.

**Dado**:  
Que o usuário consulta os parâmetros obrigatórios:
- UF: "RS"
- Cidade: "Porto Alegre"
- Logradouro: "Jo" (menos de 3 caracteres)
- Formato: "json"

**Quando**:  
A API é consultada com a URL `viacep.com.br/ws/RS/Porto+Alegre/Jo/json/`

**Então**:  
O código de resposta da API deve ser 400 (Bad Request).  
A resposta deve conter uma mensagem de erro informando que o logradouro precisa ter ao menos 3 caracteres.

---

**Cenário 18: Pesquisa com Nome de Cidade Menor que 3 Caracteres (Bad Request)
Objetivo: Validar que a API retorna um código de erro 400 caso o nome da cidade tenha menos de 3 caracteres.

**Dado**:  
Que o usuário consulta os parâmetros obrigatórios:
- UF: "RS"
- Cidade: "Po" (menos de 3 caracteres)
- Logradouro: "Domingos"
- Formato: "json"

**Quando**:  
A API é consultada com a URL `viacep.com.br/ws/RS/Po/Domingos/json/`

**Então**:  
O código de resposta da API deve ser 400 (Bad Request).  
A

## Cenário de teste escolhido para automação

- **Cenário Escolhido:** Consulta de CEP Válido.

**Justificativa:**
Foi escolhido o cenário acima por se tratar do fluxo principal de uso da API, com alta frequência de uso. A consulta de um CEP válido é o caso mais comum e relevante para os usuários da API, além de ser o caso que pode ser testado de forma automatizada para garantir que a API sempre retorne dados corretos e consistentes. Esse cenário é fundamental para a integridade da API, já que a maioria dos testes de API depende da correta resposta da API.
