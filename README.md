# Projeto-Final-Workspace

👩‍💻💻O projeto tem uma arquitetura de microsserviços desenvolvidos com Java e Spring boot que tem como 2 microsserviços principais de **filmes e diretores**

<h3><b><i>Consiste em 4 projetos no worksapce:</b></em></h3>

<blockquote>
<p>
Um discovery service : eureka-server<br />
Uma api gateway : zuul-server<br />
Dois microsserviços para cadastro de filmes e diretores : tech4movies e tech4directors
</p>
</blockquote>


<h3><b><i>Para o funcionamento correto da aplicação:</b></em></h3>

<blockquote>
<p>
  1️⃣- Subir o eureka-server / para que esteja disponível para registros.<br />
  2️⃣- Subir o zuul-server / para que esteja disponível para rotear os microsserviços.<br />
  3️⃣- Subir qualquer um dos microsserviços : tech4movies e/ou tech4directors.<br />
  Acesse http://localhost:8010/eureka no navegador para verificar se estão todos corretos.
  
  Para usar a aplicação será necessário o uso do **Postman** e usar os verbos HTTP. 

  **No Postman**<br />
  Para tech4movies: http://localhost:8011/tech4movies/api/filmes <br />
  E para ter a lista de filmes por diretores: http://localhost:8011/tech4movies/api/filmes/lista/{diretor}

  Para tech4directors:http://localhost:8011/tech4directors/api/diretores
</p>
</blockquote>


<h3><b><i>Sobre:</b></em></h3>

<blockquote>
<h3><b><i>➡Eureka-server:</b></em></h3>
<b><i>Dependêcias iniciais:</b></em><br />
Eureka Server
</p>
Serviço de descoberta.
Localiza e registra os microsserviços de uma aplicação, permitindo que seja feito o roteamento e o balanceamento de carga entre eles em um segundo momento.
Possui um módulo cliente e um servidor.

<h3><b><i>➡Zuul-server:</b></em></h3>
<b><i>Dependêcias iniciais:</b></em><br />
Eureka Client<br />
Zull
</p>
Faz o roteamento de microsserviços registrados em um discovery service. Ele atua também como balanceador de carga quando temos múltiplas instâncias de um mesmo serviço em execução, equilibrando o número de pedidos que cada uma recebe.

<h3><b><i>➡Tech4movies:</b></em></h3>
<b><i>Dependêcias iniciais:</b></em><br />
MongoDB Atlas<br />
Spring Web Restful<br />
Spring Devtools
</p>
Faz cadastro de filmes, podendo também, atualizar, deletar, obter todos os filmes cadastrados, obter os filmes passando seu Id e também obter os filmes por diretores.

<h3><b><i>➡Tech4directors:</b></em></h3>
<b><i>Dependêcias iniciais:</b></em><br />
MongoDB Atlas<br />
Spring Web Restful<br />
Spring Devtools<br />
Open Feign<br />
Hystrix
</p>
Faz cadastro de diretores(as), podendo também, atualizar, deletar, obter todos os dirtores(as) cadastrados, obter os diretores(as) passando seu Id e com isso obter os filmes que fora diirigido por ele(a)


</blockquote>
