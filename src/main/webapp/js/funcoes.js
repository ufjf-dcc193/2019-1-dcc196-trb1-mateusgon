$(document).ready(function () {

    var url_atual = window.location.href;
    if (url_atual.includes("index")) {
        $('#link1').addClass("active");
    }
    else if (url_atual.includes("sedes")) {
        $('#link2').addClass("active");
        if (url_atual.includes("detalhes")) {
            var partes = url_atual.split('/');
            var valor = partes[5];
            carregaTabelaCategoria(valor);
        }
    }
    else if (url_atual.includes("membros")) {
        $('#link3').addClass("active");
    }
    else if (url_atual.includes("atividades")) {
        $('#link4').addClass("active");
    }
    else if (url_atual.includes("sobre")) {
        $('#link5').addClass("active");
    }

    if (!url_atual.includes("sedes/editar")) {
        carregarCidadesEEstados();
    }
    else {
        carregarCidadesEEstadosModificado();
    }
});

carregarCidadesEEstados = function () {
    $.getJSON('/json/estados_cidades.json', function (data) {
        var items = [];
        var options = '<option value="">Escolha um estado</option>';
        $.each(data, function (key, val) {
            options += '<option value="' + val.nome + '">' + val.nome + '</option>';
        });
        $("#estados").html(options);

        $("#estados").change(function () {

            var options_cidades = '';
            var str = "";

            $("#estados option:selected").each(function () {
                str += $(this).text();
            });

            $.each(data, function (key, val) {
                if (val.nome == str) {
                    $.each(val.cidades, function (key_city, val_city) {
                        options_cidades += '<option value="' + val_city + '">' + val_city + '</option>';
                    });
                }
            });
            $("#cidades").html(options_cidades);

        }).change();

    });
}

carregarCidadesEEstadosModificado = function () {
    $.getJSON('/json/estados_cidades.json', function (data) {
        var atual = $("#estadoAtual").val();
        var items = [];
        var options = '<option value="' + atual + '">' + atual + '</option>';
        $.each(data, function (key, val) {
            options += '<option value="' + val.nome + '">' + val.nome + '</option>';
        });
        $("#estados").html(options);

        $("#estados").change(function () {

            var cidadeAtual = $("#cidadeAtual").val();
            var options_cidades = '';
            var str = "";

            $("#estados option:selected").each(function () {
                str += $(this).text();
            });

            if (typeof cidadeAtual !== "undefined") {
                options_cidades += '<option value="' + cidadeAtual + '">' + cidadeAtual + '</option>';
            }
            else {
                options_cidades = '';
            }

            $.each(data, function (key, val) {
                if (val.nome == str) {
                    $.each(val.cidades, function (key_city, val_city) {
                        options_cidades += '<option value="' + val_city + '">' + val_city + '</option>';
                    });
                }
            });
            $("#cidades").html(options_cidades);

        }).change();

    });
}

carregaTabela = function (infoSede, id) {
    $("#idTabela thead").remove();
    $("#idTabela tbody").remove();
    var tipoInfoSede = infoSede;
    var idSede = id;
    $.ajax({
        type: 'GET',
        url: "/sedes/detalhes/" + tipoInfoSede + "/" + idSede,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            if (tipoInfoSede.includes("atividades")) {
                var cabecalho = $("<thead> <tr> <th>Atividades</th> <th>Categoria/Horas</th> <th>Opções</th> </tr> </thead> <tbody>");
                $("#idTabela").append(cabecalho);
                for (var i = 0; i < data.length; i++) {
                    var newRow = $("<tr>");
                    var cols = "";

                    cols += '<td>' + data[i].titulo + '</td>';
                    cols += '<td>' + data[i].categoria + '/' + data[i].horasDeAtividade + '</td>';
                    cols += '<td> <a href="/atividades/detalhes/' + data[i].id + '" > <i class="material-icons">&#xe88e; </i> </a>' +
                        '<a href="/atividades/editar/' + data[i].id + '"><i class="material-icons">&#xe254;</i></a>' +
                        '<a href="/atividades/excluir/' + data[i].id + '" ><i class="material-icons">&#xe872;</i></a> </td> </tr>';
                    newRow.append(cols);
                    $("#idTabela").append(newRow);
                }
                $("#idTabela").append("</tbody>")
            }
            else {
                var cabecalho = $("<thead> <tr> <th>Membros</th> <th>Email</th> <th>Opções</th> </tr> </thead> <tbody>");
                $("#idTabela").append(cabecalho);
                for (var i = 0; i < data.length; i++) {
                    var newRow = $("<tr>");
                    var cols = "";

                    cols += '<td>' + data[i].name + '</td>';
                    cols += '<td>' + data[i].email + '</td>';
                    cols += '<td> <a href="/membros/detalhes/' + data[0].id + '" > <i class="material-icons">&#xe88e; </i> </a>' +
                        '<a href="/membros/editar/' + data[0].id + '"><i class="material-icons">&#xe254;</i></a>' +
                        '<a href="/membros/excluir/' + data[0].id + '" ><i class="material-icons">&#xe872;</i></a> </td> </tr>';
                    newRow.append(cols);
                    $("#idTabela").append(newRow);
                }
                $("#idTabela").append("</tbody>");
            }
        },
        error: function () {
            alert("Erro ao realizar requisição!");
        }

    });
}

carregaTabelaCategoria = function (id) {
    $("#idTabela thead").remove();
    $("#idTabela tbody").remove();
    var idSede = id;
    $.ajax({
        type: 'GET',
        url: "/sedes/detalhescategoria/" + idSede,
        dataType: 'json',
        success: function (data) {
            var cabecalho = $("<thead> <tr> <th>Categoria</th> <th>Horas</th> <th>Número de atividades</th></tr> </thead> <tbody>");
            $("#idTabela").append(cabecalho);
            for (var i = 0; i < data.length; i++) {
                var newRow = $("<tr>");
                var cols = "";

                cols += '<td>' + data[i].nome + '</td>';
                cols += '<td>' + data[i].horas + '</td>';
                cols += '<td>' + data[i].numeroDeAtividades + '</td>';
                newRow.append(cols);
                $("#idTabela").append(newRow);
            }
            $("#idTabela").append("</tbody>")
        },
        error: function () {
            alert("Erro ao realizar requisição!");
        }

    });
}

