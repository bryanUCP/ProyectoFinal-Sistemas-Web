document.getElementById('crear').addEventListener('click', guardarCuestionario);
  
function guardarCuestionario(e) {
      var resultElement = document.getElementById('postRegistro');

      var fechaCreacion = document.getElementById('fecha').value;
      var vigencia = document.getElementById('vigen').value;
      var nombre = document.getElementById('nombre').value;
     // resultElement.innerHTML = '';
      
          
        axios.post('http://localhost:4567/registrarCuestionario', {
            fecha_creacion: fechaCreacion,
            vigencia: vigencia,
            nombre: nombre,
            completed: false
        })

        .then(function (response) {

            //alert("Veamos si ya tienes acceso a $proyecto.");
            window.location.href = "/registrarCuestionarioForm";
        })
        .catch(function (error) {
            alert("hola");
           // window.location.href = "/home";
            //resultElement.innerHTML = generateErrorHTMLOutput(error);
            console.log(error);
        });
      
     
      //e.preventDefault();
    }