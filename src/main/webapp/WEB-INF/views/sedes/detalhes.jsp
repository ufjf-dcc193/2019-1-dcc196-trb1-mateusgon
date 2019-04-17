<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/cabecalhoAtividadeMembro.jsp" />

<div align="left">
    <h4>Nome: ${sede.nome}</h4>
    <h4>Endereço: Estado: ${sede.estado}, Cidade: ${sede.cidade}, Bairro: ${sede.bairro}</h4>
    <h4>Telefone: ${sede.telefone} </h4>
    <h4>Site: <a href="${sede.site}">${sede.site}</a></h4>
    <ul class="abas">
        <li class="aba">
            Selecione uma aba:
        </li>
        <li onclick="carregaTabelaCategoria('${sede.id}')" class="aba">
            <a href="#">Categorias</a>
        </li>
        <li onclick="carregaTabela('atividades', '${sede.id}')" class="aba">
            <a href="#">Atividades</a>
        </li>
        <li onclick="carregaTabela('membros', '${sede.id}')" class="aba">
            <a href="#">Membros</a>
        </li>
    </ul>
</div>

<main role="main" class="inner cover">
    <table id="idTabela" class="table scroll">
    </table>
</main>
<c:import url="/WEB-INF/views/layout/rodape.jsp" />