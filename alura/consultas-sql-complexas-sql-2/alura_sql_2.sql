select * from aluno
left outer join matricula on matricula.aluno_id = aluno.id
where matricula.aluno_id is null;

select a.nome from aluno a where not exists 
(select m.id from matricula m where m.aluno_id = a.id);

select a.nome from aluno a where not exists 
(select m.id from matricula m where m.aluno_id = a.id 
and m.data > now() - interval 45 day);

select * from aluno where aluno.email like '%.com' 
order by aluno.nome limit 0, 2; 

select * from aluno where aluno.nome like '%Silva%';

select curso.nome, avg(nota.nota) from curso
inner join secao on secao.curso_id = curso.id
inner join exercicio on exercicio.secao_id = secao.id
inner join resposta on resposta.exercicio_id = exercicio.id
inner join nota on nota.resposta_id = resposta.id
group by curso.nome;

select curso.nome, count(matricula.id) from curso 
inner join matricula on matricula.curso_id = curso.id
group by curso.nome;

select curso.nome, avg(nota.nota) from curso
inner join matricula on matricula.curso_id = curso.id
inner join aluno on matricula.aluno_id = aluno.id
inner join secao on secao.curso_id = curso.id
inner join exercicio on exercicio.secao_id = secao.id
inner join resposta on resposta.exercicio_id = exercicio.id
inner join nota on nota.resposta_id = resposta.id
where aluno.nome like '%Silva%' or aluno.nome like '%Santos%'
group by curso.nome; 

select exercicio.pergunta, count(resposta.id) from curso
inner join secao on secao.curso_id = curso.id
inner join exercicio on exercicio.secao_id = secao.id
inner join resposta on resposta.exercicio_id = exercicio.id
inner join nota on nota.resposta_id = resposta.id
group by exercicio.pergunta
order by count(resposta.id) desc; 

select aluno.nome, curso.nome, avg(nota.nota) from curso
inner join secao on secao.curso_id = curso.id
inner join exercicio on exercicio.secao_id = secao.id
inner join resposta on resposta.exercicio_id = exercicio.id
inner join aluno on resposta.aluno_id = aluno.id
inner join nota on nota.resposta_id = resposta.id
group by curso.id, aluno.id;

select aluno.nome, curso.nome, avg(nota.nota) from curso
inner join secao on secao.curso_id = curso.id
inner join exercicio on exercicio.secao_id = secao.id
inner join resposta on resposta.exercicio_id = exercicio.id
inner join aluno on resposta.aluno_id = aluno.id
inner join nota on nota.resposta_id = resposta.id
group by curso.id, aluno.id having avg(nota.nota) < 5;

select curso.nome, avg(nota.nota), count(matricula.id) from curso
inner join matricula on matricula.curso_id = curso.id
inner join aluno on matricula.aluno_id = aluno.id
inner join secao on secao.curso_id = curso.id
inner join exercicio on exercicio.secao_id = secao.id
inner join resposta on resposta.exercicio_id = exercicio.id
inner join nota on nota.resposta_id = resposta.id
group by curso.nome having count(matricula.id) > 1; 

select curso.nome, count(secao.id) 
from curso
inner join secao on secao.curso_id = curso.id
group by curso.nome having count(secao.id) > 3;

select distinct tipo from matricula;

select curso.nome, matricula.tipo, count(matricula.id) from curso
inner join matricula on matricula.curso_id = curso.id
where
matricula.tipo like '%PJ%' or matricula.tipo like '%PF%'
group by curso.nome;

select exercicio.pergunta, count(resposta.id) from curso
inner join matricula on matricula.curso_id = curso.id
inner join aluno on matricula.aluno_id = aluno.id
inner join secao on secao.curso_id = curso.id
inner join exercicio on exercicio.secao_id = secao.id
inner join resposta on resposta.exercicio_id = exercicio.id
where curso.id in (1, 3)
group by exercicio.pergunta; 


select 
	aluno.nome, avg(notaAluno.nota),
	avg(notaAluno.nota) - (select avg(notaGeral.nota) from nota notaGeral) as media_aluno_diferenca
from aluno
inner join resposta on resposta.aluno_id = aluno.id
inner join nota as notaAluno on notaAluno.resposta_id = resposta.id
group by aluno.nome;


select 
	aluno.nome, avg(notaAluno.nota),
	avg(notaAluno.nota) - (select avg(notaGeral.nota) from nota notaGeral) as media_aluno_diferenca
from aluno
inner join matricula on matricula.aluno_id = aluno.id
inner join resposta on resposta.aluno_id = aluno.id
inner join nota as notaAluno on notaAluno.resposta_id = resposta.id
where matricula.data  >= now() - interval 3 month
group by aluno.nome;

select c.nome, count(m.id), 
count(m.id)/(select count(id) from matricula)
from curso c join matricula m on m.curso_id = c.id
group by c.nome;

select 
	aluno.nome, resposta.resposta_dada
from aluno
left outer join resposta on resposta.aluno_id = aluno.id;

select 
	aluno.nome, resposta.resposta_dada
from aluno
left outer join resposta on resposta.aluno_id = aluno.id and resposta.exercicio_id = 1;