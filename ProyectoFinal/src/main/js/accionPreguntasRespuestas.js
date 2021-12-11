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
            alert("Pregunta:" + res.data.status); //muestra un mensaje de que se agrega la pregunta de forma correcta
            
            //PARA LIMPIAR LOS TEXT DE LOS INPUT DE AGREGAR PREGUNTA
            document.getElementById("pregunta").value="";
            document.getElementById("res1").value="";
            document.getElementById("res2").value="";
            document.getElementById("res3").value="";
            document.getElementById("res4").value="";
            document.getElementById("respuestaCorrecta").value="";
            document.getElementById("nombreCuestionario").disabled=true; //para bloquear el apartado input text del nombre cuestionario
        })
        .catch(function (error) {
            console.log(error)
        })
});