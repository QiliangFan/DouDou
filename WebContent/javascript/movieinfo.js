function check(email){
    var score=document.getElementById("scoreinput").value;
    if(typeof(score)==undefined||score==null||score==""){
        alert("请输入评分!")
        return false;
    }
    if(typeof(email)!=undefined&&email!=null&&email!=""){
        return true;
    }else{
        alert("请登陆后再评分!");
    }
    return false;
}

window.oncancel=function(){
    document.getElementById("scoreinput").value="";
}

window.onload=function(){
    var query=window.location.search;
    if(/score=true/.test(query)){
        alert("评分成功！");
        document.getElementById("scoreinput").value="";
    }else if(/s=success/.test(query)){
        alert("短评发表成功！");
        document.getElementById("writemyfilmreivew").value=""
    }else if(/s=fail/.test(query)){
        alert("每人每天只能评论一次哦");
    }
    
    
}


function checkfilmreview(){
    var email=document.getElementById("forgetemail").value;
    if(typeof(email)==undefined||email==null||email==""){
        alert("请先登陆！");
        return false;
    }
    var text=document.getElementById("writemyfilmreivew").value;
    console.log(text);
    if(typeof(text)==undefined||text==null||text==""){
        alert("客官请先说点什么嘛～")
        return false;
    }
    return true;
}