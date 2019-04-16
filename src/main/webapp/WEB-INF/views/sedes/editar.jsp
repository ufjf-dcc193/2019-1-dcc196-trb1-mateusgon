<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/cabecalho.jsp" />

<main role="main" class="inner cover">
    <form method="post" action="editar">
        <div class="form-group">
            <label for="nomeSede">Nome da Sede</label>
            <input type="text" class="form-control" name="nome" id="nomeSede" value="${sede.nome}"
                placeholder="Digite o nome da sede" required>
        </div>
        <div class="form-group">
            <label for="estadoSede">Escolha o estado</label>
            <select name="estado" class="form-control" id="estados" required>
                <option id="estadoAtual" value="${sede.estado}" selected>${sede.estado}</option>
            </select>
        </div>
        <div class="form-group">
            <label for="cidadeSede">Escolha a cidade</label>
            <select name="cidade" class="form-control" id="cidades" required>
                <option id="cidadeAtual" value="${sede.cidade}" selected>${sede.cidade}</option>
            </select>
        </div>
        <div class="form-group">
            <label for="nomeSede">Bairro da Sede</label>
            <input type="text" class="form-control" name="bairro" id="bairroSede" value="${sede.bairro}"
                placeholder="Digite o bairro da sede" required>
        </div>
        <div class="form-group">
            <label for="nomeSede">Telefone da sede</label>
            <input type="text" class="form-control" name="telefone" id="telefone" value="${sede.telefone}"
                placeholder="Digite o telefone da sede" required>
        </div>
        <div class="form-group">
            <label for="nomeSede">Site da sede</label>
            <input type="url" class="form-control" name="site" id="siteSede" value="${sede.site}"
                placeholder="Digite o site da sede">
        </div>
        <input id="id" name="id" type="hidden" value="${sede.id}"/> 
        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
</main>
<c:import url="/WEB-INF/views/layout/rodape.jsp" />