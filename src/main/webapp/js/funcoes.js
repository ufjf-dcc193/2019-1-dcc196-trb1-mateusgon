$(document).ready(function () {

    var url_atual = window.location.href;
    if (url_atual.includes("index")) {
        $('#link1').addClass("active");
    }
    else if (url_atual.includes("sedes")) {
        $('#link2').addClass("active");
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
    else
    {
        carregarCidadesEEstadosModificado();
    }

});

function carregarCidadesEEstados() {
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

function carregarCidadesEEstadosModificado() {
    $.getJSON('/json/estados_cidades.json', function (data) {
        var atual = $("#estadoAtual").val();
        var items = [];
        var options = '<option value="'+atual+'">'+atual+'</option>';
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

            if(typeof cidadeAtual !== "undefined") {
                options_cidades += '<option value="' + cidadeAtual + '">' + cidadeAtual + '</option>';
            }
            else
            {
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
