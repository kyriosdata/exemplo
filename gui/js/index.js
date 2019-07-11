// Path para a requisição (URL)
const PATH = "http://localhost:8080/ds?data=";

function atualizaDiaDaSemana() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let dds = extraiDiaDaSemanaDaResposta(xhttp.responseText);
            document.getElementById("resultado").innerHTML = dds;
        }
    };
    
    let dataAnoMesDia = document.getElementById("data").value;
    let data = formataData(dataAnoMesDia);
    xhttp.open("GET", PATH + data, true);
    xhttp.send();
}

/**
* Seta a data atual do sistema na tag input da pagina principal(index.html).
*/
function dataCorrente() {
    document.getElementById("data").valueAsDate = new Date();
}

// Funções para integração (satisfazer contrato do servidor)

function extraiDiaDaSemanaDaResposta(resposta) {
    return JSON.parse(resposta).diaDaSemana;
}

// Dia ou mês deve possuir dois dígitos
function formataDiaOuMes(n) {
    return ("00" + n).substr(-2, 2);
}

// Ano deve possuir quatro dígitos
function formataAno(n) {
    return ("0000" + n).substr(-4,4);
}

// ENTRADA: ano-mes-dia SAIDA: dd-mm-yyyy
function formataData(data) {
    let [a, m, d] = data.split("-");
    
    let dia = formataDiaOuMes(d);
    let mes = formataDiaOuMes(m);
    let ano = formataAno(a);
    
    return `${d}-${m}-${a}`;
}