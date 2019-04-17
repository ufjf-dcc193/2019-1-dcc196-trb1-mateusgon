<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/cabecalhoAtividadeMembro.jsp" />

<main role="main" class="inner cover">
    <table class="table scroll">
        <thead>
            <tr>
                <th>Funcionário</th>
                <th>Informações</th>
                <th>Contato</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Membro: ${membro.name}</td>
                <td>Função: ${membro.funcao}</td>
                <td>Email: ${membro.email} </td>
            </tr>
            <tr>
                <td> Data de entrada: ${dataDeEntrada} </td>
                <td> Data de saída: ${dataDeSaida} </td>
                <td>
                    Sede: ${membro.sede.nome}
                </td>
            </tr>
        </tbody>
    </table>
</main>
<c:import url="/WEB-INF/views/layout/rodape.jsp" />