document.getElementById('crear').addEventListener('click', guardarCuenta);
  
function guardarCuenta(e) {
      var resultElement = document.getElementById('postRegistro');

      var correo = document.getElementById('correo').value;
      var password = document.getElementById('clave').value;
     // resultElement.innerHTML = '';
      
          
        axios.post('http://localhost:4567/accesoUsuarios', {
            correo: correo,
            clave: password,
            completed: false
        })

        .then(function (response) {

            alert(response.data);
            var respuesta = response.data;

            if(respuesta === "error"){
                window.location.href ="/acceso";
            }else{
                window.location.href ="/homeProfesor?correo="+correo;
            }

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