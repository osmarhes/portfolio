------------------------------------------------------- 
• Sistema para gerenciar os dados do portfólio de projetos de uma empresa. Entenda como portfólio de projetos o conjunto de projetos da empresa, tanto em andamento como em análise de viabilidade 
• O candidato pode escolher os frameworks e melhor forma de implementação 
Regras de negócio: 
[ ] O sistema deve permitir o cadastro (inserção, exclusão, alteração e consulta) de projetos. Para cada projeto devem ser informados: nome, data de início, gerente responsável, previsão de término, data real de término, orçamento total, descrição e status. 
[ ] Os projetos devem ser classificados em: baixo risco, médio risco e alto risco. A classificação de risco não é cadastrada no sistema. 
[ ] A cada instante, o projeto deve estar em um status específico e único. Os status possíveis não são cadastrados no sistema e são: em análise, análise realizada, análise aprovada, iniciado, planejado, em andamento, encerrado, cancelado. 
[ ] Se um projeto foi mudado o status para iniciado, em andamento ou encerrado não pode mais ser excluído 
[ ] O sistema não deve permitir o cadastro de um novo membro diretamente. Deve ser provida funcionalidade via web service, contendo nome e atribuição (cargo). 
[ ] O sistema deve permitir associar membros aos projetos que tem atribuição funcionário 
Entrega: 
• O teste deverá ser enviado em um e-mail contendo o link para o repositório deste projeto em sua conta pessoal no GitHub.
Script do banco de dados: 
● Este script criará as tabelas necessárias. 
● A estrutura criada não deve ser alterada! 
-- ----------------------------------------------------- 
-- Table Pessoa 
-- ----------------------------------------------------- 
CREATE TABLE pessoa 
( id bigserial NOT NULL, 
nome character varying(100) NOT NULL, 
datanascimento date, 
cpf character varying(14), 
funcionario boolean, 
CONSTRAINT pk_pessoa PRIMARY KEY (id)); 
-- ----------------------------------------------------- 
-- Table Projeto 
-- ----------------------------------------------------- 
CREATE TABLE projeto ( 
id bigserial NOT NULL, 
nome VARCHAR(200) NOT NULL, 
data_inicio DATE , 
data_previsao_fim DATE , 
data_fim DATE , 
descricao VARCHAR(5000) , 
status VARCHAR(45) , 
orcamento FLOAT , 
risco VARCHAR(45) , 
idgerente bigserial NOT NULL, 
CONSTRAINT pk_projeto PRIMARY KEY (id), 
CONSTRAINT fk_gerente FOREIGN KEY (idgerente) 
REFERENCES pessoa (id) MATCH SIMPLE 
ON UPDATE NO ACTION ON DELETE NO ACTION) 
-- ----------------------------------------------------- 
-- Table Membros 
-- ----------------------------------------------------- 
CREATE TABLE membros 
( idprojeto bigserial NOT NULL, 
idpessoa bigint NOT NULL, 
CONSTRAINT pk_membros_projeto PRIMARY KEY (idprojeto), 
CONSTRAINT fk_membros_pessoa FOREIGN KEY (idpessoa) 
REFERENCES projeto (id) MATCH SIMPLE 
ON UPDATE NO ACTION ON DELETE NO ACTION, 
CONSTRAINT fk_pessoa FOREIGN KEY (idpessoa) 
REFERENCES pessoa (id) MATCH SIMPLE 
ON UPDATE NO ACTION ON DELETE NO ACTION); 

Critérios de avaliação:
[ ] • Persistir as informações no BD de forma adequada
[ ] • Sintaxe e Semântica corretas 
[ ] • Aplicação das práticas ‘’Clean Code’’ 
[ ] • Utilização do Padrão MVC 
[ ] • Utilização corretas dos conceitos de Orientação a Objetos 
[ ] • Padrão na construção das classes e nas nomenclaturas 
[ ] • Criação de testes unitários 
[ ] • Implementação das regras de negócio 
[ ] • Issues do sonar (Dica: Pluggin Sonar Lint no IntelliJ) 
[ ] • Implementação de interface visual usando boas práticas