<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/cabecalho.jsp" />

<main role="main" class="inner cover">

  <table class="table scroll">
    <thead>
      <tr>
        <th>Membros</th>
        <th>Opções</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="membro" items="${membros}">
        <tr>
          <td>${membro.name}</td>
          <td>
            <a href="/membros/detalhes?id=${membro.id}" ><i class="material-icons">&#xe88e;</i></a>            
            <a href="/membros/editar?id=${membro.id}" ><i class="material-icons">&#xe254;</i></a>
            <a href="/membros/excluir?id=${membro.id}" ><i class="material-icons">&#xe872;</i></a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</main>
<a href="/membros/criar" class="btn btn-outline-dark" role="button">Cadastrar membro</a>
<c:import url="/WEB-INF/views/rodape.jsp" />