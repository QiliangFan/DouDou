
window.onload=signlog_onclick

function signlog_onclick(){
    document.getElementsByName("signup")[0].onclick=verify_signup;
    document.getElementsByName("login")[0].onclick=verify_login;
}

function verify_signup(){
    var email=document.getElementById("email").value;
    var pwd1=document.getElementById("pwd1").value;
    var pwd2=document.getElementById("pwd2").value;
    var pat=/[0-9a-zA-Z]+@[0-9a-zA-Z]+.[a-zA-Z]+/;
    var valid=pat.test(email);
    if(!valid||email==""){
        alert("邮箱格式不正确！");
        window.location.href="signup.jsp";
        window.location.reload();
        return false;   
    }else if(!email||!pwd1||!pwd2||email==""||pwd1==""||pwd2==""){
        alert("请填写有效信息！");
        window.location.href="signup.jsp";
        window.location.reload();
        return false;
    }else if(pwd1!=pwd2){
        alert("两次密码输入不一致，清重新输入。")
        window.location.href="signup.jsp";
        window.location.reload();
        return false;
    }else{
        return true;
    }
}

function verify_login(){
    var email=document.getElementById("email").value;
    var pwd=document.getElementById("pwd").value;
    var pat=/[0-9a-zA-Z]+@[0-9a-zA-Z]+.[a-zA-Z]+/;
    var valid=pat.test(email);
    if(!valid||email==""){
        alert("邮箱格式不正确！");
        window.location="login.jsp";
        window.location.reload();
        return false;
    }else if(!email||!pwd||email==""||pwd2==""){
        alert("请填写有效信息！");
        window.location.href="login.jsp";
        window.location.reload();
        return false;
    }else{
        return true;
    }
}