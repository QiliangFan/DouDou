window.onload=getfilmreview

function getfilmreview(){
    var str=location.href;
    var num=str.indexOf("?");
    if(num<0) 
        window.location.href="./SERVLET/filmreview";
}