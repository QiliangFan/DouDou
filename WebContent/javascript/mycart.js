function sub(e){
    window.location.href="CartSub?movieName="+e.value.toString();
}

function  add(e) {
    window.location.href="CartAdd?movieName="+e.value.toString();
}

function buy(){
    window.location.href="ClearCart";
}