const email = document.querySelector("#email");
const password = document.querySelector("#password");
const checkbox = document.querySelector("#switch");
const button = document.querySelector("#submit");
const form = document.querySelector("#form");


const condition = (value, expression) => {
    const regex = new RegExp(expression);
    return value.length !== 0 && !regex.test(value);
};
//Events

const regexEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g;
const regexPassword =
    /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[\d])(?=.*?[^\w\s]).{8,}$/g;
form.addEventListener("submit", () => {
    const login = form.email.value;
    console.log(email);
    const pwd = form.password.value;
    console.log(email);
    if (condition(login, regexEmail) && condition(pwd, regexPassword)) {
        form.submit();
    }
});

checkbox.addEventListener("click", function (e) {
    if (this.checked) {
        password.type = "text";
    } else {
        password.type = "password";
    }
});
email.addEventListener("input", toggleInputChange);
password.addEventListener("input", toggleInputChange);

function toggleInputChange(e) {
    if (e.target.value !== "") {
        e.target.parentNode.classList.add("active");
    } else if (e.target.value === "") {
        e.target.parentNode.classList.remove("active");
    }

    let expression;
    if (this.type === "email") {
        expression = regexEmail;
    } else if (this.type === "password" || this.type === "text") {
        expression = regexPassword;
    }

    if (condition(e.target.value, expression)) {
        this.classList.add("error");
    } else {
        this.classList.remove("error");
    }
}
