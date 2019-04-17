<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/cabecalhoAtividadeMembro.jsp" />


  <table class="table scroll">
    <thead>
      <tr>
        <th>Membros</th>
        <th>Sede</th>
        <th>Opções</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="membro" items="${membros}">
        <tr>
          <td>${membro.name}</td>
          <td>${membro.sede.nome}</td>
          <td>
            <a href="/membros/detalhes/${membro.id}" ><i class="material-icons">&#xe88e;</i></a>            
            <a href="/membros/editar/${membro.id}" ><i class="material-icons">&#xe254;</i></a>
            <a href="/membros/excluir/${membro.id}" ><i class="material-icons">&#xe872;</i></a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

<a href="/membros/criar" class="btn btn-outline-dark" role="button">Cadastrar membro</a>
<c:import url="/WEB-INF/views/layout/rodape.jsp" />