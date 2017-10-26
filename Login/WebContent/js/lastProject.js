var lis = document.getElementsByTagName("li");
var p1 = document.getElementById("p1");
var liDivs = document.getElementsByClassName("liDiv");
var register = document.getElementById("register");
var iRegUs = document.getElementById("iRegUs");
var iRegPw = document.getElementById("iRegPw");

var ifoUl = document.getElementById("ifoUl");

var iLogin = document.getElementById("iLogin");
var iPass = document.getElementById("iPass");
var iUser = document.getElementById("iUser");

var url = "http://localhost:8080/Second/";
var url1 = "http://www.kingswim.xyz";

var length = lis.length;

iRegUs.onchange = function(){
	isUser(iRegUs.value);
};

iLogin.onclick = function(){
	var iPass1 = iPass.value;
	var iUser1 = iUser.value;
//	alert(1);
	compareUser(iUser1,iPass1);
};

register.onclick = function() {
//  alert(iRegUs.value);
	var iRegUs1 = iRegUs.value;
	var iRegPw1 = iRegPw.value;
	
//	isUser(iRegUs1);
	if(iRegUs1!="" && iRegPw1!=""){
		createLi(iRegUs1);
        addUser(iRegUs1,iRegPw1);
	}else{
		alert("注册错误，用户名或密码为空！");
	}
	
    
};

function removeLi(username){
	var li1 = document.getElementById(username);
	ifoUl.removeChild(li1);
	
	delUser(username);
}


function createLi(username){
	var li1 = document.createElement("li");
	li1.id = username;
    li1.innerHTML = username + "<input type='button' value='Remove' onclick='removeLi(" + username + ")' />";
    ifoUl.appendChild(li1);
}


changeLiStyle();

function changeLiStyle() {
	for(let i = 0; i < length; i++) {

		lis[i].onclick = function() {
			for(let j = 0; j < length; j++) {
				lis[j].className = "";
			}
			for(let x = 0; x < length; x++) {
				liDivs[x].style.display = "none";
			}
			lis[i].className = "lihover";
            liDivs[i].style.display = "block";
		};
	}

}


function ajaxGet(url, data, callback) {

	var xhr = new XMLHttpRequest();
	xhr.open("GET", url + "?" + data, true);
	xhr.send();
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			var result = xhr.responseText;

			if(callback) {
				callback(result);
			}
		}
	};
}

function getAll(){
	
	var urlAll = url + "all";
	ajaxGet(urlAll,"",function(result){
		
		var json = JSON.parse(result);
		
		if(json.code == 1){
			var users = json.users;
			for(var i=0 ;i<users.length; i++){
			    var user = users[i];
			    createLi(user.username);
			}
		}else{
			
		}
		
	});
	
}
getAll();


function addUser(username,password) {

	var urlAdd = url + "add";
	var data = "username=" + username + "&password=" + password;
	ajaxGet(urlAdd,data,function(result){
		if(result == 1){
			alert("注册成功!");
		}else{
			alert("注册失败!");
		}
	});
}

function delUser(username) {

	var urlDel = url + "delete";
	var data = "username=" + username;
	ajaxGet(urlDel,data,function(result){
		if(result == 1){
			alert("删除成功!");
		}else{
			alert("删除失败!");
		}
	});
}


function compareUser(username,password){
	
	var urlAll = url + "all";
	var flag = 0;
	ajaxGet(urlAll,"",function(result){
		
		var json = JSON.parse(result);
		
		if(json.code == 1){
			var users = json.users;
			for(var i=0 ;i<users.length; i++){
			    if(username==users[i].username && password==users[i].password){
			    	flag = 1;
			    }else{
			    	flag = 0;
			    }
			}
		}else{
			
		}
		
		
		if(flag == 1){
			alert("登陆成功，画面即将跳转!");
			setTimeout(function(){
				window.location = url1;
			},10);
		}else{
			alert("用户不匹配 ，请重新输入或前往注册！");
		}
	});
	
}


function isUser(str){
	
	var userStr = /^[0-9]{1,20}$/;
	var isSuccess = userStr.test(str);
	if(str == ""){
		p1.innerHTML = "";
	}else if(isSuccess == true){
		p1.innerHTML = "账号有效!(仅数字)";
		p1.style.color = "green";
	}else if(isSuccess == false){
		p1.innerHTML = "账号无效!请重新输入!(仅数字)";
		p1.style.color = "red";
	}
	
}


