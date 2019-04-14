<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/cabecalho.jsp" />

<main role="main" class="inner cover">
    <form method="post" action="criar">
        <div class="form-group">
            <label for="nomeSede">Nome da Sede</label>
            <input type="text" class="form-control" name="nome" id="nomeSede" placeholder="Digite o nome da sede">
        </div>
        <div class="form-group">
            <label for="estadoSede">Escolha o estado</label>
            <select name="estado" class="form-control" id="estados">
                <option value=""></option>
            </select>
        </div>
        <div class="form-group">
            <label for="cidadeSede">Escolha a cidade</label>
            <select name="cidade" class="form-control" id="cidades">
                <option value=""></option>
            </select>
        </div>
        <div class="form-group">
            <label for="nomeSede">Bairro da Sede</label>
            <input type="text" class="form-control" name="bairro" id="bairroSede" placeholder="Digite o bairro da sede">
        </div>
        <div class="form-group">
            <label for="nomeSede">Telefone da sede</label>
            <input type="text" class="form-control" name="telefone" id="telefone" placeholder="Digite o telefone da sede">
        </div>
        <div class="form-group">
            <label for="nomeSede">Site da sede</label>
            <input type="text" class="form-control" name="site" id="siteSede" placeholder="Digite o site da sede">
        </div>
        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
</main>
<c:import url="/WEB-INF/views/rodape.jsp" />