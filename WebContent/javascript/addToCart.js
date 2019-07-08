function addToCart(email,movieName){
    if(typeof(email)==undefined||email==null||email==""){
        alert("请先登陆！");
    }else{
        window.location.href="addToCart?email="+email+"&movieName="+movieName+"&addtocart=t";
    }
    
}

window.onload=function(){
    var q=window.location.search;
    if(/s=success/.test(q)){
        alert("已成功添加至购物车！");
    }
}