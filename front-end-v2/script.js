const form = document.querySelector('form');
const inName = document.querySelector('.name');
const inBirthday = document.querySelector('.birthday');
const inFallWinterSemester = document.querySelector('.fallWinterSemester');
const inSpringSummerSemester = document.querySelector('.springSummerSemester');

function insert () {

    fetch("/http://localhost:8080/students", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({ 
            name: inName.value,
            birthDay: inBirthday.value,
            fallWinterSemester: inFallWinterSemester.value,
            SpringSummerSemester: inSpringSummerSemester.value,
         })
    })
    .then(function (res)  { console.log(res) })
    .catch(function (res) { console.log(res) })
};

function clearFields() {
    inName.value = "";
    inBirthday.value = "";
    inFallWinterSemester.value = "";
    inSpringSummerSemester.value = "";
};

form.addEventListener('submit', function (event) {
    event.preventDefault();

   insert();
   clearFields();

});