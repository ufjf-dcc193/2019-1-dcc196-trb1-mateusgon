<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/cabecalho.jsp" />

<main role="main" class="inner cover">
    <form method="post" action="criar">
        <div class="form-group">
            <label for="tituloAtividade">Título da atividade</label>
            <input type="text" class="form-control" name="titulo" value=${atividade.titulo} id="tituloAtividade"
                placeholder="Digite o título da atividade" required>
        </div>
        <div class="form-group">
            <label for="textoAtividade">Texto de descrição</label> <br />
            <textarea name="descricao">${atividade.descricao}</textarea>
        </div>
        <div class="form-group">
            <label for="categoria">Escolha a categoria</label>
            <select name="categoria" class="form-control" id="categoria" required>
                <option value="Assistencial"> Assistencial </option>
                <option value="Jurídica"> Jurídica </option>
                <option value="Financeira"> Financeira </option>
                <option value="Executiva"> Executiva </option>
            </select>
        </div>
        <div class="form-group">
            <label for="horasDeAtividade">Horas de atividade</label>
            <input type="number" class="form-control" name="horasDeAtividade" id="horasDeAtividade"
                placeholder="Horas de atividade (Utilize somente números)" value="${atividade.horasDeAtividade}"
                required>
        </div>
        <div class="form-group">
            <label for="dataDeInicio">Data de entrada</label>
            <input type="date" class="form-control" name="dataDeInicio" id="dataDeInicio"
                placeholder="Digite a data de início" value="${dataDeInicio}" required>
        </div>
        <div class="form-group">
            <label for="dataDeFim">Data de saída</label>
            <input type="date" class="form-control" name="dataDeFim" id="dataDeFim" placeholder="Digite a data de fim"
                value="${dataDeFim}" required>
        </div>
        <div class="form-group">
            <label for="cidadeSede">Escolha a sede</label>
            <select name="sedeAtividade" class="form-control" id="sedes">
                <option value="${sede.id}" selected> ${sede.nome} </option>
                <c:forEach var="sedeAux" items="${sedes}">
                    <c:if test="${sede.nome != sedeAux.nome}">
                        <option value="${sedeAux.id}"> ${sedeAux.nome} </option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <input id="id" name="id" type="hidden" value="${atividade.id}" />
        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
</main>
<c:import url="/WEB-INF/views/layout/rodape.jsp" />