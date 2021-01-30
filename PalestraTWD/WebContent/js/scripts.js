function required()
{
var empt1 = document.forms["Login"]["username"].value;
var empt2 = document.forms["Login"]["password"].value;
var empt3 = document.forms["Login"]["autorita"].value;
var empt4 = document.forms["Login"]["nome"].value;
var empt5 = document.forms["Login"]["cognome"].value;
if (empt1 == "" || empt2 == "" || empt3 == "" || empt4 == "" || empt5 == "")
{
alert("Uno o più campi sono vuoti, riprova.");
return false;
}
else 
{
alert('Code has accepted : you can try another');
return true; 
}
}