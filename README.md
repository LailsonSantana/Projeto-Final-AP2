# Projeto Final AP2
 Projeto final da disciplina de **Algoritmos e Programação 2**
 ***
 ### Funcionalidades :
 * Cadastrar uma Criptomoeda
 * Adicionar uma compra
    * Pode ser tanto em dolar quanto em real , o aplicativo faz a conversão
 * Adicionar uma venda
 * Calculo de Preço Médio
 ***
 ### O que falta implementar :
 1. Remover Criptomoeda
 2. Calculo de lucro ou prejuizo
 3. Algo que impessa o usuário vender uma certa quantidade de criptomoeda quando ele não tiver saldo
 4. Menu de informações
    1. Mostrar ultimas 3 compras
    2. Mostrar ultimas 3 vendas
    3. Mostrar lucro ou prejuízo
 5.Melhorias no layout (Nenhuma estilização foi feita)

- [ ] Remover Criptomoeda
- [ ] Calculo de lucro ou prejuizo
- [ ] Algo que impessa o usuário vender uma certa quantidade de criptomoeda quando ele não tiver saldo
- [ ] Menu de informações
- [ ] Melhorias no layout

***

![Tela Inicial](https://user-images.githubusercontent.com/70287747/124542248-6cfc4780-ddf9-11eb-8514-74d0b9e90498.png)

***
Integrantes do Grupo :
Nome | Matrícula
---|---
Lailson Santana |201911924
Mateus Dória |
Jhonatas Rodrigues |

***

Comando `doc.getElementsByTag()`

***

```
private String converterToJson(Dolar d){
        String json = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(d);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
```
***

bhteh @

[Meu Facebook](https://www.facebook.com/lailson.santana.52)

