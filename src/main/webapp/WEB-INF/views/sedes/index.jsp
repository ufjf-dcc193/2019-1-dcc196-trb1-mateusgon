<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/cabecalho.jsp" />

<main role="main" class="inner cover">

  <table class="table scroll">
    <thead>
      <tr>
        <th>Sede</th>
        <th>Opções</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="sede" items="${sedes}">
        <tr>
          <td>${sede.nome}</td>
          <td>
            <a href="/sedes/detalhes?id=${sede.id}" ><i class="material-icons">&#xe88e;</i></a>            
            <a href="/sedes/editar?id=${sede.id}" ><i class="material-icons">&#xe254;</i></a>
            <a href="/sedes/excluir?id=${sede.id}" ><i class="material-icons">&#xe872;</i></a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</main>
<a href="/sedes/criar" class="btn btn-outline-dark" role="button">Cadastrar sede</a>
<c:import url="/WEB-INF/views/layout/rodape.jsp" />