<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/cabecalho.jsp"/>

<main role="main" class="inner cover">
    <table class="table">
        <thead>
          <tr>
            <th scope="col">Nome</th>
            <th scope="col">Opções</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>Mark</td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Larry</td>
          </tr>
        </tbody>
      </table>
</main>

<c:import url="/WEB-INF/views/rodape.jsp"/>