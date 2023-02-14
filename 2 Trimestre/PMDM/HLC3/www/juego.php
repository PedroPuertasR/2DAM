<?php  
include 'conexionbd.php';
session_start();

if (isset($_SESSION['masControl']))
{
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
    <title>Adivina el número</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="d-flex justify-content-center align-items-center">

    <?php

    $sumar = 0;
    $fecha_actual = date("Y-m-d");

    if (!isset($_POST["respuesta"]) || isset($_POST["reset"])) {
        
        $numero_a_adivinar = random_int(1, 100);
        echo "<script>console.log('Variable: ', ".json_encode($numero_a_adivinar).");</script>";
        $limite_inferior = 1;
        $limite_superior = 100;
        $intentos = 1;
    } else {
        $numero_a_adivinar = $_POST["numero_a_adivinar"];
        echo "<script>console.log('Variable: ', ".json_encode($numero_a_adivinar).");</script>";
        $limite_inferior = $_POST["limite_inferior"];
        $limite_superior = $_POST["limite_superior"];
        $intentos = $_POST["intentos"];

        $respuesta = (int) $_POST["respuesta"];

        if ($respuesta == $numero_a_adivinar) {
            echo '<p>¡Felicidades, has adivinado el número en ' . $intentos . ' intentos!</p>';
            echo '<div class="d-flex justify-content-center"><form action="juego.php" method="post">';
            echo '<input type="submit" name="reset" value="Jugar de nuevo">';
            echo '</form>';

            $con=conexion();
            $sql="UPDATE USUARIOS SET INTENTOS = " . $intentos . ", FECHA_RECORD = '" . $fecha_actual . "' WHERE EMAIL='" . $_SESSION['email'] . "';";
            $resultado=mysqli_query($con, $sql);
            mysqli_close($con);

            exit;
        } else{
            echo "<p>Número incorrecto</p>";
            $sumar = random_int(1, 15);
            $limite_inferior = $numero_a_adivinar - $sumar;
            if($limite_inferior < 1){
                $limite_inferior = 1;
            }
            $sumar = random_int(1, 15);
            $limite_superior = $numero_a_adivinar + $sumar;
            if($limite_superior > 100){
                $limite_superior = 100;
            }
        }

        $intentos++;
    }
    ?>

    </div>
    <form action="juego.php" method="post">
        <input type="hidden" name="numero_a_adivinar" value="<?php echo $numero_a_adivinar; ?>">
        <input type="hidden" name="limite_inferior" value="<?php echo $limite_inferior; ?>">
        <input type="hidden" name="limite_superior" value="<?php echo $limite_superior; ?>">
        <input type="hidden" name="intentos" value="<?php echo $intentos; ?>">
        Adivine un número entre <?php echo $limite_inferior; ?> y <?php echo $limite_superior; ?>:
        <input type="number" name="respuesta" size="5">
        <input type="submit" value="Adivinar">
    </form>
</body>
</html>
