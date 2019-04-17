<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/cabecalhoAtividadeMembro.jsp" />

<main role="main" class="inner cover">
    <table class="table scroll">
        <thead>
            <tr>
                <th>Atividade</th>
                <th>Informações</th>
                <th>Datas</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Título: ${atividade.titulo}</td>
                <td>Categoria: ${atividade.categoria}</td>
                <td>Data de início: ${dataDeInicio} </td>
            </tr>
            <tr>
                <td> Descrição: ${atividade.descricao} </td>
                <td> Sede: ${atividade.sede.nome}
                </td>
                <td>
                    Data de fim: ${dataDeFim}
                </td>
            </tr>
        </tbody>
    </table>
</main>
<c:import url="/WEB-INF/views/layout/rodape.jsp" />