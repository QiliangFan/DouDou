window.onload=function(){
    document.getElementById("submit").onclick=modify;
    initpage();
}

function modify(){
    var pwd1=document.getElementById("pwd1").value;
    var pwd2=document.getElementById("pwd2").value;
    if(!pwd1|!pwd2){
        alert("请输入有效信息！");
    }else if(pwd1!=pwd2){
        alert("两次密码输入不一致请重新输入！");
    }else{
        return true;
    }
    return false;
}

