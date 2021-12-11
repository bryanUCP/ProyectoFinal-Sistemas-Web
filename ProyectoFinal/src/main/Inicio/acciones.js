var crearCuestionario = document.getElementById("guardarCuestionario");
crearCuestionario.addEventListener("click", () => {
    axios.post("http://localhost:4567/cuestionarioProfe", {
        correoProfesor: document.getElementById("correoProfesor").value,
        nombre: document.getElementById("nombre").value,
        vigencia: document.getElementById("vigencia").value,
        EE: document.getElementById("EE").value
    })
        .then(function (res) {
            let opcion = res.data;
            if(opcion=="cuestionario agregado"){
            alert("Cuestionario:" + res.data.status);

            }
        })
        .catch(function (error) {
            console.log(error)
        })
});


var agregarPregunta = document.getElementById("agregarPregunta");
agregarPregunta.addEventListener("click", () => {
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
            alert("Cuestionario:" + res.data.status);
            
        })
        .catch(function (error) {
            console.log(error)
        })
});