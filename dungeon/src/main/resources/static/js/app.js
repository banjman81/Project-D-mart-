/**
 * 
 */
	var modal = document.getElementById("myModal").addEventListener("onclick", function(event){
		event.preventDefault()
	});
	var btn = document.getElmentById("myBtn");
	var span = document.getElementByClassName("close")[0];
	btn.onclick = function(){
		modal.style.display = "block";
		}
	span.onclick = function(){
		modal.style.display = "none";
		}
	window.onclick = function(event) {
		  if (event.target == modal) {
		    modal.style.display = "none";
		  }
		}