document.getElementById('crear').addEventListener('click', guardarCuenta);
  
function guardarCuenta(e) {
      var resultElement = document.getElementById('postRegistro');

      var nombres = document.getElementById('nombres').value;
      var apellidos = document.getElementById('apellidos').value;
      var correo = document.getElementById('correo').value;
      var password = document.getElementById('claveAl').value;
     // resultElement.innerHTML = '';
      
          
        axios.post('http://localhost:4567/registrar', {
            nombre: nombres,
            apellido: apellidos,
            correo: correo,
            clave: password,
            completed: false
        })

        .then(function (response) {

            alert("Veamos si ya tienes acceso a $proyecto.");
           // window.location.href = "/home";
        })
        .catch(function (error) {
            alert("hola");
           // window.location.href = "/home";
            //resultElement.innerHTML = generateErrorHTMLOutput(error);
            console.log(error);
        });
      
     
      //e.preventDefault();
    }