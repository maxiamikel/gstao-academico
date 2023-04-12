function gerarMatricula() {
    var texto = "E-";
    var numero = Math.floor(Math.random() * 1000);
    document.getElementById("matricula").value = (texto + numero);
}