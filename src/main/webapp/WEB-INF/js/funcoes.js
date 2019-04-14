$(document).ready(function() {
    
    var url_atual = window.location.href;
    if(url_atual.includes("index") || url_atual.includes("localhost"))
    {
        $('#link1').addClass("active");
    }
    else if(url_atual.includes("sedes"))
    {
        $('#link2').addClass("active");
    }
    else if(url_atual.includes("membros"))
    {
        $('#link3').addClass("active");
    }
    else if(url_atual.includes("atividades"))
    {
        $('#link4').addClass("active");
    }
    else
    {
        $('#link5').addClass("active");
    }
});

