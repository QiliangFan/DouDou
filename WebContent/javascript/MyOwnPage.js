

function initpage(){
    setTimeout(verify,2000);
}
function verify(){
    var email=document.getElementById("transport").value;
    if(!email){
        window.location.href="main.jsp";
    }
    
}



function myinfo(){
    window.location.href="MyOwnPage.jsp";
}


function mycart(){ 
    window.location.href="MyCart";
    
}


function history(){
    window.location.href="History";
}

function myfilmreview(){
    window.location.href="GetMyFilmReview";
}

function manage(){ 
    window.location.href="GetAllFilmReview";
}