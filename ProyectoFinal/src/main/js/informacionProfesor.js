var informacion = document.getElementById("perfilProfesor");
informacion.addEventListener("click", function () {
    let email = document.getElementById("correoProfesor").value;
    axios.get("http://localhost:4567/InfoProfesor", {
        params: {
            email2: email //para buscar los datos de ese profesor mediante su correo, lo mandamos al app.java    
        }
    })
    .then(function (res) {
        let json = res.data;
        let n = document.getElementById("nombre");
        let a = document.getElementById("apellido");
        let e = document.getElementById("email");
        let p = document.getElementById("pasword");
        let r = document.getElementById("rol");
        for (var clave in json) {
            // Controlando que json realmente tenga esa propiedad
            if (json.hasOwnProperty(clave)) {
                // Mostrando en pantalla la clave junto a su valor
                // alert("La clave es " + clave + " y el valor es " + json[clave]);
                let nombre1 = document.createElement("li");
                let apellido1 = document.createElement("li");
                let email1 = document.createElement("li");
                let pasword1 = document.createElement("li");
                let rol1 = document.createElement("li");

                nombre1.textContent ="Nombre de profesor: "+json[clave].nombre;
                apellido1.textContent = "APellido: "+json[clave].apellido;
                email1.textContent ="Correo: "+json[clave].email;
                pasword1.textContent ="password "+json[clave].password;
                rol1.textContent ="Rol: "+json[clave].rol;

                n.appendChild(nombre1);
                a.appendChild(apellido1);
                e.appendChild(email1);
                p.appendChild(pasword1);
                r.appendChild(rol1);
            }
        }
    })
    .catch()
})