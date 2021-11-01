<?php
if(isset($_POST['name']) && isset($_POST['email']) && 
    isset($_POST['subject']) && isset($_POST['message'])) 
{
    $name = htmlentities($_POST['name']);    
    $email = htmlentities($_POST['email']);
    $subject = htmlentities($_POST['subject']);
    $message = htmlentities($_POST['message']);

    $content = "Letter fom $name.
    Client's email: $email
    Message: $message";

/* Устанавливаем e-mail адресата */
$myemail = "contact@copytradingforex.com";

$tema = "WRITE_US"+$subject;

/* Отправляем сообщение, используя mail() функцию */
mail($myemail, $tema, $content);
$redirect = isset($_SERVER['HTTP_REFERER'])? $_SERVER['HTTP_REFERER']:'redirect-form.html';
header("Location: $redirect");
exit();
}
else
{   
    echo "Your data is incorrect. Please, try again!";
}
?>