function nameBlur() {
    if ("" == document.getElementById("username").value
        || "请输入用户名" == document.getElementById("username").value) {
        document.getElementById("username").value = "请输入用户名";

    }
}

function nameFocus() {
    if ("请输入用户名" == document.getElementById("username").value) {
        document.getElementById("username").value = "";

    }
}

function modifySubmit() {
    if ("" == document.getElementById("username").value
        || "请输入用户名" == document.getElementById("username").value) {
        document.getElementById("usernameMsg").innerHTML="<font color='red'>用户名不能空</font>";
        document.getElementById("password1Msg").innerHTML="";
        document.getElementById("password2Msg").innerHTML="";
        document.getElementById("emailMsg").innerHTML="";
        document.getElementById("username").focus();
        return false;
    }


    if ("" == document.getElementById("password1").value) {
        document.getElementById("usernameMsg").innerHTML="";
        document.getElementById("password1Msg").innerHTML="<font color='red'>密码不能空</font>"
        document.getElementById("password2Msg").innerHTML="";
        document.getElementById("emailMsg").innerHTML="";
        document.getElementById("password1").focus();
        return false;
    }

    if ("" == document.getElementById("password2").value) {
        document.getElementById("usernameMsg").innerHTML="";
        document.getElementById("password1Msg").innerHTML="";
        document.getElementById("password2Msg").innerHTML="<font color='red'>请验证密码</font>";
        document.getElementById("emailMsg").innerHTML="";
        document.getElementById("password2").focus();
        return false;
    }
    if ("" == document.getElementById("email").value) {
        document.getElementById("usernameMsg").innerHTML="";
        document.getElementById("password1Msg").innerHTML="";
        document.getElementById("password2Msg").innerHTML="";
        document.getElementById("emailMsg").innerHTML="<font color='red'>请输入邮箱</font>"
        document.getElementById("email").focus();
        return false;
    }
    if (""!= document.getElementById("password1").value
        && document.getElementById("password2").value!=document.getElementById("password1").value) {
        document.getElementById("usernameMsg").innerHTML="";
        document.getElementById("password1Msg").innerHTML="";
        document.getElementById("password2Msg").innerHTML="<font color='red'>两次密码不匹配</font>";
        document.getElementById("emailMsg").innerHTML="";
        document.getElementById("password2").focus();
        return false;
    }


}



function passwordBlur2() {
    if ("" == document.getElementById("password2").value) {
        document.getElementById("registPasswordMsg2").innerHTML="<font color='grey'>请确认密码。</font>";
    }
    //两次密码不同，就显示不同
    if (""!= document.getElementById("password1").value
        && document.getElementById("password2").value!=document.getElementById("password1").value) {
        document.getElementById("password2Msg").innerHTML="<font color='grey'>两次密码不匹配</font>";

    }
    //两次密码一样，就显示ok
    if (""!= document.getElementById("password1").value
        && document.getElementById("password2").value==document.getElementById("password1").value) {

        document.getElementById("password2Msg").innerHTML="<font color='grey'>OK</font>";
    }
}