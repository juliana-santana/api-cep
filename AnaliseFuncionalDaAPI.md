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