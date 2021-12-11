var iniciar = document.getElementById("Aceptar");
iniciar.addEventListener("click", function () {
    let email2 = document.getElementById("correo").value;
    let password2 = document.getElementById("contrasena").value;
    axios.get("http://localhost:4567/verificarUsuario", { //Mandamos los datos al backend App.java
        params: {
            email: email2,
            password: password2,
        }
    })
        .then(function (res) {
            let resul = res.data; //Recibe los datos del backend - App.java
            if(resul !=null){
           if (resul == true) {
                alert("Profesor "+resul);
                window.location.replace('profesor.html'); 
            } 
            if(resul == false){
                alert("Estudiante");
                window.location.replace('alumno.html'); 
            }
          }else{
              alert("Datos no encontrados");
          }
        })
        .catch(function (error) {
            console.log(error);
        });
});