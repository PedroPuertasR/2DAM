<html>
<head>
    <title>Adivina el número</title>
</head>
<body>
    <?php
    if (!isset($_POST["respuesta"]) || isset($_POST["reset"])) {
        $numero_a_adivinar = rand(1, 100);
        $limite_inferior = 1;
        $limite_superior = 100;
        $intentos = 0;
    } else {
        $numero_a_adivinar = $_POST["numero_a_adivinar"];
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
        } elseif ($respuesta < $numero_a_adivinar) {
            echo "El número es mayor<br>";
            $limite_inferior = $respuesta + 1;
        } else {
            echo "El número es menor<br>";
            $limite_superior = $respuesta - 1;
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
        <input type="text" name="respuesta" size="5">
        <input type="submit" value="Adivinar">
    </form>
</body>
</html>
