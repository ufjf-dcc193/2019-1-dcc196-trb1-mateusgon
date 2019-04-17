<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/cabecalhoAtividadeMembro.jsp" />

<main role="main" class="inner cover">

  <table class="table scroll">
    <thead>
      <tr>
        <th>Atividades</th>
        <th>Sede</th>
        <th>Opções</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="atividade" items="${atividades}">
        <tr>
          <td>${atividade.titulo}</td>
          <td>${atividade.sede.nome}</td>
          <td>
            <a href="/atividades/detalhes/${atividade.id}" ><i class="material-icons">&#xe88e;</i></a>            
            <a href="/atividades/editar/${atividade.id}" ><i class="material-icons">&#xe254;</i></a>
            <a href="/atividades/excluir/${atividade.id}" ><i class="material-icons">&#xe872;</i></a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</main>
<a href="/atividades/criar" class="btn btn-outline-dark" role="button">Cadastrar atividades</a>
<c:import url="/WEB-INF/views/layout/rodape.jsp" />