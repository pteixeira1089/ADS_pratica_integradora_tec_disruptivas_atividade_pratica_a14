## Notas ao professor que irá corrigir a atividade:
### O que foi solicitado

Implementação de métodos na construção da API que possibilitem as seguintes buscas:

1. ProjetoRepository: buscar pela descrição do projeto
2. RecursoRepository: buscar pelo nome do recurso;
3. TarefaRepository: buscar pelo status da tarefa;

Foram solicitadas implementações completas, ou seja, que fizéssemos as implementações necessárias nas camadas 'repository', 'service' e 'controller', e não apenas na camada 'repository'.


### O que foi feito
Utilizei, como modelo inicial, a estrutura do projeto disponível no repositório da aula 14, que pode ser acessado em https://github.com/FaculdadeDescomplica/pratica_integradora_tecnologias_disruptivas/tree/main/modulo14.

Na estrutura do projeto em questão, reparei que já os métodos de pesquisa solicitados já estavam criados na camada 'repository', mas não nas camadas 'service' e 'controller'. Dessa forma, fiz as seguintes implementações no projeto:
1. Adaptações nos métodos já criados na camada 'repository':

  *ProjetoRepository.java*
  Criei um método adicional para permitir a pesquisa por projetos que CONTENHAM a string passada como parâmetro de busca.
  O método que já estava criado fazia apenas a busca por projetos que continham EXATAMENTE a descrição passada.

  *TarefaRepository.Java*
  O método que já estava criado exigia que o parâmetro passado fosse O OBJETO StatusTarefa (uma instância da entidade StatusTarefa.java)
  Alteri o método para que o usuário final pudesse passar apenas uma string que representasse o status. Para tanto, adaptei o método para que buscasse tarefas cujo campo 'statusDescricao' da entidade 'StatusTarefa' relacionada fosse igual ao parâmetro passado como string.

  
  *Implementações no service*
  Em seguida, procedi às implementações dos métodos de busca mencionados acima na camada service, para os respectivos arquivos associados a cada entidade, seguindo o que fora explicado na aula 14 e anteriores (em especial a aula 6 e anteriores, que abordaram a criação de API no Spring Boot).

  *Implementações no controller*
  Por fim, procedi às implementações no controller, expondo endpoints ao usuário final, que poderá fazer uso dos recursos criados. Neste ponto, foi necessário fazer ajustes nas rotas das solicitações, a fim de que não houvesse dois endpoints disponibilizados para a mesma rota. Nesse sentido, por exemplo, pode-se citar que, na camada RecursoController.java, o endpoint que permitia uma requisição do tipo GET para buscar recursos por id foi ajustado para um novo endereço, a fim de que também se criasse o endpoint que permite a busca de recursos por nome.
  
