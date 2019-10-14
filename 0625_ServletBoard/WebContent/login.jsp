<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
@import "compass/css3";

$button: rgba(148,186,101,0.7);

body {
  background: #384047;
  font-family: sans-serif;
  font-size: 10px
}
form {
  background: #fff;
  padding: 4em 4em 2em;
  max-width: 400px;
  margin: 50px auto 0;
  box-shadow: 0 0 1em #222;
  border-radius: 2px;
  h2 {
    margin:0 0 50px 0;
    padding:10px;
    text-align:center;
    font-size:30px;
    color:darken(#e5e5e5, 50%);
    border-bottom:solid 1px #e5e5e5;
  }
  p {
    margin: 0 0 3em 0;
    position: relative;
  }
  input {
    display: block;
    box-sizing: border-box;
    width: 100%;
    outline: none;
    margin:0;
  }
  input[type="text"],
  input[type="password"] {
    background: #fff;
    border: 1px solid #dbdbdb;
    font-size: 1.6em;
    padding: .8em .5em;
    border-radius: 2px;
  }
  input[type="text"]:focus,
  input[type="password"]:focus {
    background: #fff
  }
  span {
    display:block;
    background: #F9A5A5;
    padding: 2px 5px;
    color: #666;
  }
  input[type="submit"] {
    background: $button;
    box-shadow: 0 3px 0 0 darken($button, 10%);
    border-radius: 2px;
    border: none;
    color: #fff;
    cursor: pointer;
    display: block;
    font-size: 2em;
    line-height: 1.6em;
    margin: 2em 0 0;
    outline: none;
    padding: .8em 0;
    text-shadow: 0 1px #68B25B;
  }
  input[type="submit"]:hover {
    background: rgba(148,175,101,1);
    text-shadow:0 1px 3px darken($button, 30%);
  }
  input[type="submit"]:hover {
    
  }
  label{
    position: absolute;
    left: 8px;
    top: 12px;
    color: #999;
    font-size: 16px;
    display: inline-block;
    padding: 4px 10px;
    font-weight: 400;
    background-color: rgba(255,255,255,0);
    @include transition(color .3s, top .3s, background-color .8s);
    &.floatLabel{
      top: -11px;
      background-color: rgba(255,255,255,0.8);
      font-size: 14px;
    }
	}
  
}
</style>
</head>
<body>
<form action="frontAction" method="get">
<input type="hidden" name="action" value="login">
  <h2>로그인</h2>
		<p>
			<label for="Email" class="floatLabel">ID : </label>
			<input id="Email" name="userId" value="${userId}" type="text">
			<br><font color="red">${message}</font>
		</p>
		<p>
			<label for="password" class="floatLabel">PW : </label>
			<input id="password" name="userPw" value="${userPw}"type="password">
		</p>
		<p>
			<input type="submit" value="로그인" id="submit">
		</p>
	</form>
	<script>
	//Problem: Hints are shown even when form is valid
	//Solution: Hide and show them at appropriate times
	var $password = $("#password");
	var $confirmPassword = $("#confirm_password");

	//Hide hints
	$("form span").hide();

	function isPasswordValid() {
	  return $password.val().length > 8;
	}

	function arePasswordsMatching() {
	  return $password.val() === $confirmPassword.val();
	}

	function canSubmit() {
	  return isPasswordValid() && arePasswordsMatching();
	}

	function passwordEvent(){
	    //Find out if password is valid  
	    if(isPasswordValid()) {
	      //Hide hint if valid
	      $password.next().hide();
	    } else {
	      //else show hint
	      $password.next().show();
	    }
	}

	function confirmPasswordEvent() {
	  //Find out if password and confirmation match
	  if(arePasswordsMatching()) {
	    //Hide hint if match
	    $confirmPassword.next().hide();
	  } else {
	    //else show hint 
	    $confirmPassword.next().show();
	  }
	}

	function enableSubmitEvent() {
	  $("#submit").prop("disabled", !canSubmit());
	}

	//When event happens on password input
	$password.focus(passwordEvent).keyup(passwordEvent).keyup(confirmPasswordEvent).keyup(enableSubmitEvent);

	//When event happens on confirmation input
	$confirmPassword.focus(confirmPasswordEvent).keyup(confirmPasswordEvent).keyup(enableSubmitEvent);

	enableSubmitEvent();
</script>
	
</body>
</html>