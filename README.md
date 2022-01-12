# Clean Code (Udemy)
Este projeto é parte integrante do curso sobre o livro "Clean Code" disponibilizado na Udemy.

Para maiores informações acesse o [curso na Udemy](https://www.udemy.com/course/clean-code-na-pratica/?referralCode=24F598EE94626485768C)

## Clean Code
“Clean Code” é uma filosofia, um guia ou conjunto de boas práticas para escrever código de forma que ele possa ser lido e entendido por outros programadores.

Github do [curso](https://github.com/refactown/cleancode/tree/master/src/main/java/refactown/cleancode).

![Ciclo Eficácia](images/artesoftware-cleancode-ciclo-eficacia.png)

- Pequenas Coisas Importam: "Quem não faz bem as pequenas coisas, não faz bem coisa alguma". Nomenclatura, padrões, formatação, comentários, etc, devem ser valorizados. Essas pequenas tarefas, ao longo do tempo, garantirão a manutenção desta produtividade.
- Código é Requisito Detalhado. O Código fonte é detalhamento dos requisitos e deve expressar o negócio.
- Comunique, não Codifique. Código deve ser feito para ser lido por outra pessoa, deve ser legível, não apenas por máquinas.
- Código ruim gera baixa produtividade que gera código pior.

*Atitude:*
- "Regra do escoteiro". Ao acampar os escoteiros levam bagagens, e ao partir do camping ele leva o lixo que produziu e também o lixo que já estava antes no local. Essa é uma boa prática, tentar deixar o código um pouco melhor do que o estado em que foi econtrado, toda oportunidade de alterar um código é uma boa oportunidade de deixá-lo melhor.

Artigos:
[Dívida Tecnica](https://artesoftware.com.br/2019/02/10/divida-tecnica/)
[Introdução a Clean Code](https://artesoftware.com.br/2020/08/02/clean-code/)
[The CLean Code Blog. Robert C. Martin](https://blog.cleancoder.com/uncle-bob/2014/06/20/MyLawn.html)

## Conceitos /  Boas Práticas

### DDD
Do negócio ao código via Domain Driven Design. Separar o que é do negócio do que é da tecnologia.
- O requisito está no código, o domínio de um problema organiza os conceitos sobre os quais é baseada a solução de software.
- Foco no Negócio. Parte do código deve expressar o negócio.
- Isolamento do Domínio. O código de domínio é idiossincrático (próprio, específico) e particular.
- Infraestrutura à Parte. Tecnologias vêm e vão, o negócio permanece.

Recomenda-se a separação em camadas: User Interface, Application, Domain, Infrastructure.

**Vocabulário**
- Linguagem Onipresente (Ubíqua). Presente na fala de todos e no código de domínio, não deixa dúvidas, são termos usados pelos desenvolvedores e pelos especialistas de negócio.
- Contexto Delimitado. Partes bem delimitadas de um domínio, pois é possível que esteja-se trabalhando em um negócio muito grande. Candidatos a microserviços.
- Tijolos de Construção. Entidades, Objetos de Valor, Eventos de Domínio, Serviços, Fábricas, Repositórios.

## Princípio da Responsabilidade Única (SRP)
"Cada módulo de um software deve ter um e apenas um motivo para mudar". <br>
Ele deve ser responsável por uma funcinalidade apenas. Se ele estiver responsável por mais, na alteração de uma das funcionalidades é possível que haja impactos nas demais. Torna-se necessária a compreensão de mais fluxos e regras de negócio além do necessário.

Resumindo: Um pedaço de código faz UMA FUNCIONALIDADE.

## Princípio da Não Repetição (DRY)
`Don't Repeat Yourself (DRY)`, não se repita (código, requisito, teste, etc). Não repita código em lugares diferentes.<br>
Toda parte do conhecimento deve ter uma `representação única` e livre de ambiguidades em todo o sistema.

Resumindo: Uma funcionalidade existe em apenas UM LOCAL do código.

Problemas:
- Mais trabalho: alterar mais vezes
- Mais risco: encontrar todos os lugares em que se deve alterar
- Mais teste: testar várias vezes a mesma coisa
- Mais esforço de comunicação. Fu

## Indireção ou Delegação

Forma de evitar duplicação de código e manter uma responsabilidade única em um trecho de código. Exemplo:
![Delegação](images/delegacao.png)

## Lei de Demeter (Princípio do Menor Conhecimento)

Um módulo não deve enxergar o interior dos objetos que ele manipula.

Um método "m" de uma classe "C" só deve chamar:
- Objetos do tipo "C"
- Parâmetros passados para o método "m" (ex. "x: P")
- Um objeto criado pelo próprio método "m"
- Variáveis de instância da classe "C" (ex. "a: A")

Deve-se evitar Train Wreck (Acidente de Trem): x.getY().getZ().

<img src="images/lei-demeter.png" alt="Lei Demeter" width="200" />

## Acoplamento e Coesão

Coesão de uma classe:
- Poucas variáveis de instância
- Cada método manipula uma ou mais

Alto Acoplamento | Baixa Coesão:
- Poucas classes e grandes
- Maior dependência por classe (imports). A alteração em um ponto pode interferir em *n* funcionalidades
- Maior conhecimento entre elementos

Baixo Acoplamento | Alta Coesão (desejado): :star:
- Muitas classes e pequenas
- Menos dependência por classe
- Menor conhecimento

## Imutabilidade

**Quanto mais imutável melhor.**
Evite Surpresas: Imutabilidade é uma defesa contra "efeitos colaterais", já que pode haver manipulação indesejada no objeto. Havendo manipulação deve haver a verificação se algo foi alterado em algum momento, isso também deixa de ser necessário.

`private final int idade;`

Vantagens:
- Mais seguro e confiável
- Mais legível: minimiza testes e garantias, diminui o código por tabela
- Paralelismo e escalabilidade

## Funções Puras (em Orientação a Objetos)
Produz mais simplicidade de leitura.
Função Pura:
1. Para um certo Input sempre retorna o mesmo Output.
2. Não causa nenhum efeito colateral, não impacta nada além do escopo da própria função.
3. Não depende de nenhum dado externo (autocontida), deve ser simples, objetiva, como uma função soma, poucas entradas e saídas.

Vantagens:
- Mais simples e menores
- Mais fácil de entender e testar

**Quando usar em código OO?**
Sempre que possível. Em muitas situações não é possível: BD (acesso a dado externo, efeito colateral), integração, estados, etc.
Possível em regras de negócio, métodos utilitáeios

## Testes de Unidade Tempestivos
Teste Tempestivo

**TDD - Test Driven Development**
Desenvolvimento Guiado por Testes, ação de desenvolvimento. O teste é feito primeiro e depois o código para satisfazer o teste.
- Escreve um teste que falha antes do código produtivo
- Faz o teste passar ao construir o código produtivo
- Refatora o código até o teste falhar (ou não)

**Testes Tempestivos (TDD inclusive)**
Teste que ajuda na construção, logo, cedo.
1. Atividade de engenharia (código e design)
2. Feedback rápido sobre o código testado (erra cedo)
3. Gera código limpo através da "dificuldade" de testar
4. Antecida o custo gasto em correções e debug
5. Ainda serve como teste de regressão

Duas pernas do Clean Code, teste unitário e refatoração.

## Refatoração Tempestiva
*"Refatoração (refactoring) é a disciplina técnica para reestruturar um determinado código, alterando sua estrutura interna `sem mudar seu comportamento externo`".* Martin Fowler

Refatoração não é reengenharia. Por exemplo alteração de um método que recebia um parâmetro e vai passar a receber três.

Refatoração é ágil, são pequenas mudanças que fazem diferença no longo prazo. Ajuste da solução em função de uma nova visão sobre o problema, ou para preparar uma evolução ou mudança.

O primeiro código possivelmente não é o melhor possível, o mais expressivo, ou cumpre todos os princípios.
![Refatoracao](images/refatoracao-fluxo.png)

## As 4 regras da Simplicidade (Martin Fowler/ Kent Beck)
1. Alta cobertura de testes. Todos os testes passam.
2. Revela a Intenção, o próprio código explica o que ele faz, sem auxílio de explicação.
3. Nenhuma duplicação
4. Mínimo de Elementos, fazer as três primeiras regras com o mínimo possível.

![Regras da simplicidade](images/regras-simplicidade.png)

## Revisão dos conceitos

![Revisão](images/revisao-conceitos.png)

### Filosofia sobre código Limpo (Visão Geral)

 - O código não fica nem se mantém limpo sozinho
 - `Todos` na equipe devem praticar e cobrar
 - Manter o código limpo é uma `atividade diária`, não deixar acumular
 - Funciona como na "Teoria das janelas quebradas", quando algo está bem tratado a tendência é continuar tratando bem, quando está mal tratada a tendência é tratar pior no decorrer do tempo.
 - `Atitude` é mais relevante do que "patrocínio", a atitude muitas vezes conta mais do que o tempo devido pela sprint, cobrança da liderança.
 - Sempre dá pra começar (regra do escoteiro)
 - Ler e entender consome mais tempo que escrever
 - Precisa de `tempo, técnica e treino` ára fazer bem

### Filosofia sobre Nomes

Exemplo de código ruim em [c02names\BadCode](src\main\java\refactown\cleancode\c02names\BadCode.java).
E refatoração em em [c02names\Refactoring](src\main\java\refactown\cleancode\c02names\Refactoring.java).

 - Nomes são muito importantes (especialmente em OO)
 - Use nomes que `revelam seu propósito`, evite nomes não pronunciáveis
 - Evite informações erradas(ex.: "itemList: Map", um map com nome de list)
 - Faça distinções significativas (evite a1, a2, a3, n)
 - Nomes `pronunciáveis` e `passíveis de busca`
 - Evite codificações, por exemplo notação húngara (strNome, intIdade) e similares
 - `classes` = substantivos, `métodos` = verbos
 - Selecione uma palavra por conceito (get, set, find)
 - Nomes do `problema` (pedido, item, restaurante, relacionados à domínnio) e da `solução` (DAO, Repository, Mapper), ex.: OrderMapper, OrderMapper, ItemService
 - Adicione ou evite contexto quando necessário. Contexto desnecessário no exemplo: `EnderecoDoCliente enderecoDeCobrancaDoCliente=new EnderecoDoCliente();`
 - Evite `números mágicos`, valores numéricos inseridos no meio do código e não são inseridos em uma variável com nome descritivo. Deve-se criar uma constante para o número mágico, sendo passível de busca e rastreio no código.

#### Código Ruim (Nomes)

Exemplo de código ruim em [megasena/MegaSenaV0](src\main\java\refactown\cleancode\megasena\MegaSenaV0.java).
Em [megasena/MegaSenaV3](src\main\java\refactown\cleancode\megasena\MegaSenaV3.java) já se tem uma nomenclatura mais descritiva, funções separadas para cada atividade, utilização do stream em local do for, recurso mais novo do java, formatação.

**Problemas**
 - Nomes ruins
 - Função grande e complexa (SRP)
 - Comentários questionáveis
 - Formatação inexistente

**Dificuldades**
 - Legibilidade: confuso
 - Testabilidade: alta complexidade

### Filosofia sobre Comentários
"Qualquer um pode escrever código que o computador entenda. Bons programadores escrevem códigos que os humanos entendem". *Martin Fowler*

 - Comentários são a última opção do programador.
 - O programador deve expressar-se no código.
 - Comunique, não codifique (outros devem ler).
 - Comentário pode estar compensando código ruim.
 - Alguns comentários são bons ou necessários. 

Evitar:
 - comentários ruidosos, muito longos ou repettivos
 - Imperativos (i.e em todas as funções)
 - Marcadores de posição ////////// ou ********
 - Comentários em HTML no meio do código Java
 - Cabeçalhos de funções (prefira um bom nome)
 - Javadoc em código não público

Resumindo: Comentário é o último recurso.

## Developer
Kamila Serpa

[1]: https://www.linkedin.com/in/kamila-serpa/
[2]: https://gitlab.com/java-kamila

[![linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)][1]
[![gitlab](https://img.shields.io/badge/GitLab-330F63?style=for-the-badge&logo=gitlab&logoColor=white)][2]
