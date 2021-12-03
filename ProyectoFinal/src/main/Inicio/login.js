var iniciar = document.getElementById("Aceptar");
iniciar.addEventListener("click", function () {
    let email2 = document.getElementById("correo").value;
    let password2 = document.getElementById("contrasena").value;
    axios.get("http://localhost:4567/verificarUsuario", { //Mandamos los datos al backend
        params: {
            email: email2,
            password: password2,
        }
    })
        .then(function (res) {
            let resul = res.data; //Recibe los datos del backend - App.java
            if (resul == "Profesor") {
                alert("profesor");
                window.location.replace('profesor.html'); 
            } else {
                alert("estudiante");
                window.location.replace('estudiante.html'); 
            }
        })
});