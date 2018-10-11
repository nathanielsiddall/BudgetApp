
//this sets the wrong info div to visible. use it when wiring to the server.
// wrongInfo.style.visibility ="visible";

const id = (ID)=>{return document.getElementById(ID)};

const username = id("username");
const password = id("password");
const submit = id("submit");
const wrongInfo =id("wrongInfo");


submit.onclick = ()=>{
    console.log("preAuthenticate test");
    fetch("/login", {
        method:"POST",
        headers:{"content-type": "application/x-www-form-urlencoded",},

        body: `username=${username.value}&password=${password.value}`

    }).then((response)=>{
        fetch("/logincheck").then((response)=>{

            console.log(response);
            wrongInfo.style.visibility ="visible";
        })


    });


};

window.addEventListener('keyup', (e) =>{
    if (e.key === "Enter"){
        submit.click();
    }
});

