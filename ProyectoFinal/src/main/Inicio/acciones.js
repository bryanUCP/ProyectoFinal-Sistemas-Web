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
