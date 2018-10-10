
//this sets the wrong info div to visible. use it when wiring to the server.
// wrongInfo.style.visibility ="visible";

const id = (ID)=>{return document.getElementById(ID)};

const username = id("username");
const password = id("password");
const submit = id("submit");
const wrongInfo =id("wrongInfo");


submit.onclick = ()=>{
    //things to do when you click the submit
};

window.addEventListener('keyup', (e) =>{
    if (e.key === "Enter"){
        submit.click();
    }
});

