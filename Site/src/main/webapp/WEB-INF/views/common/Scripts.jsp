<!-- Script For Side Navigation -->
	<script>
		function w3_open() {
			var x = document.getElementById("mySidenav");
			x.style.width = "300px";
			x.style.textAlign = "center";
			x.style.fontSize = "40px";
			x.style.paddingTop = "10%";
			x.style.display = "block";
		}
		function w3_close() {
			document.getElementById("mySidenav").style.display = "none";
		}

		// Used to toggle the menu on smaller screens when clicking on the menu button
		function openNav() {
			var x = document.getElementById("navDemo");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}

		function showLang() {
			var menu = document.getElementById("language-menu-id");

			if (menu.className.indexOf("w3-show") == -1) {
				menu.className += " w3-show";

			} else {
				menu.className = menu.className.replace(" w3-show", "");
			}
		}
	</script>