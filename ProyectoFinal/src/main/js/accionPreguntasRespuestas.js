var AgregarPregunta = document.getElementById("agregarPregunta");
AgregarPregunta.addEventListener("click", () => {
    axios.post("http://localhost:4567/AgregarPregunta", {
        nombreCuestionario: document.getElementById("nombreCuestionario").value,
        pregunta: document.getElementById("pregunta").value,
        res1: document.getElementById("res1").value,
        res2: document.getElementById("res2").value,
        res3: document.getElementById("res3").value,
        res4: document.getElementById("res4").value,
        respuestaCorrecta: document.getElementById("respuestaCorrecta").value
    })
        .then(function (res) {
            alert("Pregunta:" + res.data.status);
            
        })
        .catch(function (error) {
            console.log(error)
        })
});