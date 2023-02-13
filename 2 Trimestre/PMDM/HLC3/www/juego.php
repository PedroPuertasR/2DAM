<html>
<head>
    <title>Adivina el número</title>
</head>
<body>
    <?php

    $sumar = 0;
    $fecha_actual = date("Y-m-d");

    if (!isset($_POST["respuesta"]) || isset($_POST["reset"])) {
        
        $numero_a_adivinar = random_int(1, 100);
        echo "<script>console.log('Variable: ', ".json_encode($numero_a_adivinar).");</script>";
        $limite_inferior = 1;
        $limite_superior = 100;
        $intentos = 0;
    } else {
        $numero_a_adivinar = $_POST["numero_a_adivinar"];
        echo "<script>console.log('Variable: ', ".json_encode($numero_a_adivinar).");</script>";
        $limite_inferior = $_POST["limite_inferior"];
        $limite_superior = $_POST["limite_superior"];
        $intentos = $_POST["intentos"];

        $respuesta = (int) $_POST["respuesta"];

        if ($respuesta === $numero_a_adivinar) {
            echo "¡Felicidades, has adivinado el número en $intentos intentos!<br>";
            echo '<form action="juego.php" method="post">';
            echo '<input type="submit" name="reset" value="Jugar de nuevo">';
            echo '</form>';
            exit;
        } else{
            echo "El número es mayor<br>";
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
