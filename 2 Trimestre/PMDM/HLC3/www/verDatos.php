<?php  
include 'conexionbd.php';
session_start();
//isset — Determina si una variable está definida y no es null
if (isset($_SESSION['masControl']))
{
	if($_SESSION['sesionJuego']==true)
	{
		echo "<script>
				var peticion=confirm('Sesion correcta ¿continuas?');
				console.log(peticion);
				if(peticion){
					console.log(peticion);
				}     			
			</script>";
	}
	$con=conexion();
	$sql="UPDATE USUARIOS SET GANADAS=" . $_SESSION['victorias'] .", PERDIDAS=" . $_SESSION['perdidas'] . " WHERE EMAIL='" . $_SESSION['email'] . "';";
	$resultado=mysqli_query($con, $sql);
	mysqli_close($con);
}
else
{
	session_destroy();
	header("location:./index.php");
}
?>
<html>
	<head>
		<meta charset="UTF-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Inicio</title>
	</head>
	<body>
		<div class="caja_usuario">
			<div class="datos_usuario">
				<h1 class="text-center m-5"><?php echo ' ' .$_SESSION['nombre'] . ' ' . $_SESSION['apellido'];?></h1> 
			</div>
			<div class="puntuacion_usuario">
				<p class="victorias">Victorias: <?php echo $_SESSION['victorias'];?> </p>
				<br/>
				<p class="derrotas">Derrotas: <?php echo $_SESSION['perdidas'];?> </p>
			</div>
		</div>	
		
		<div class="container mt-3">
			<h2>Tabla de records</h2>
			<table class="table table-bordered">
				<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Ganadas</th>
					<th>Perdidas</th>
					<th>Record</th>
					<th>Fecha</th>
				</tr>
				</thead>
				<tbody>
					<?php

					include 'consultasTablaUsuarios.php';

					$jugadores=obtenerTodosUsuarios();

					foreach($jugadores as $jugador)
					{
						echo '<tr>';
						echo '<td>' . $jugador['nombre'] . '</td>';
						echo '<td>' . $jugador['apellidos'] . '</td>';
						echo '<td>' . $jugador['ganadas'] . '</td>';
						echo '<td>' . $jugador['perdidas'] . '</td>';
						echo '<td>' . $jugador['intentos'] . '</td>';
						echo '<td>' . $jugador['fecha_record'] . '</td>';
						echo '</tr>';
					}
											
					?>
				</tbody>
			</table>
			</div>
	</body>
</html> 
