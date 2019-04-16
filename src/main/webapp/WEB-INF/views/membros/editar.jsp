<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/cabecalho.jsp" />

<main role="main" class="inner cover">
    <form method="post" action="criar">
        <div class="form-group">
            <label for="nomeMembro">Nome do membro</label>
            <input type="text" value="${membro.name}" class="form-control" name="name" id="nomeMembro"
                placeholder="Digite o nome do membro" required>
        </div>
        <div class="form-group">
            <label for="funcaoMembro">Função do membro</label>
            <input type="text" class="form-control" value="${membro.funcao}" name="funcao" id="funcaoMembro"
                placeholder="Digite a função do funcionário" required>
        </div>
        <div class="form-group">
            <label for="email">Email do membro</label>
            <input type="email" class="form-control" value="${membro.email}" name="email" id="email"
                placeholder="Digite o email do membro" required>
        </div>
        <div class="form-group">
            <label for="dataDeEntrada">Data de entrada</label>
            <input type="date" class="form-control" name="dataDeEntrada"
                id="dataDeEntrada" placeholder="Digite a data de entrada" value="${dataDeEntrada}" required>
        </div>
        <div class="form-group">
            <label for="dataDeSaida">Data de saída</label>
            <input type="date" class="form-control" name="dataDeSaida" id="dataDeSaida"
            placeholder="Digite a data de saída" value="${dataDeSaida}" required>
        </div>
        <div class="form-group">
            <label for="cidadeSede">Escolha a sede</label>
            <select name="sedeMembro" class="form-control" id="sedes" required>
                <option value="${sede.id}" selected> ${sede.nome} </option>
                <c:forEach var="sedeAux" items="${sedes}">
                    <c:if test="${sede.nome != sedeAux.nome}">
                        <option value="${sedeAux.id}"> ${sedeAux.nome} </option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <input id="id" name="id" type="hidden" value="${membro.id}"/> 
        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
</main>
<c:import url="/WEB-INF/views/layout/rodape.jsp" />