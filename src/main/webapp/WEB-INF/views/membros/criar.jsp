<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/cabecalho.jsp" />

<main role="main" class="inner cover">
    <form method="post" action="/membros/criar">
        <div class="form-group">
            <label for="nomeMembro">Nome do membro</label>
            <input type="text" class="form-control" name="name" id="nomeMembro" placeholder="Digite o nome do membro" required>
        </div>
        <div class="form-group">
            <label for="funcaoMembro">Função do membro</label>
            <input type="text" class="form-control" name="funcao" id="funcaoMembro"
                placeholder="Digite a função do funcionário" required>
        </div>
        <div class="form-group">
            <label for="email">Email do membro</label>
            <input type="text" class="form-control" name="email" id="email" placeholder="Digite o email do membro" required>
        </div>
        <div class="form-group">
            <label for="dataDeEntrada">Data de entrada</label>
            <input type="date" class="form-control" name="dataDeEntrada" id="dataDeEntrada"
                placeholder="Digite a data de entrada" required>
        </div>
        <div class="form-group">
            <label for="dataDeSaida">Data de saída</label>
            <input type="date" class="form-control" name="dataDeSaida" id="dataDeEntrada"
                placeholder="Digite a data de saída" required>
        </div>
        <div class="form-group">
            <label for="cidadeSede">Escolha a sede</label>
            <select name="sedeMembro" class="form-control" id="sedes" required>
                <c:forEach var="sede" items="${sedes}">
                    <option value="${sede.id}"> ${sede.nome} </option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
</main>
<c:import url="/WEB-INF/views/layout/rodape.jsp" />