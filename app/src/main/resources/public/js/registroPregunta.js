document.getElementById('crear').addEventListener('click', guardarPregunta);
  
function guardarPregunta(e) {
      var resultElement = document.getElementById('postRegistro');

      var pregunta = document.getElementById('question').value;
      var num = document.getElementById('punta').value;
      var idC= document.getElementById('cuestionario').value;
      var puntaje = new Number(num);
      var cuestionario = new Number(idC);
     // resultElement.innerHTML = '';
      
          
        axios.post('http://localhost:4567/registrarPreguntas', {
            contenido: pregunta,
            puntaje: puntaje,
            id_cuestionario: cuestionario,
            completed: false
        })

        .then(function (response) {

            //alert("Veamos si ya tienes acceso a $proyecto.");
            window.location.href = "/registrarPreguntasForm?id="+idC;
        })
        .catch(function (error) {
            alert("hola");
           // window.location.href = "/home";
            //resultElement.innerHTML = generateErrorHTMLOutput(error);
            console.log(error);
        });
      
     
      //e.preventDefault();
    }