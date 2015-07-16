function getXHR(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	{	// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{	// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp
}

function sendEvent(param_event){
	event = param_event;
	time = new Date().getTime();
	
	var xmlhttp = getXHR();
	xmlhttp.onreadystatechange=responseCallback;
	xmlhttp.open("POST", "/test3", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("event="+event+"&time="+time);
}

function sendAJAX(httpmethod, endpoint, message, callback){	
	var xmlhttp = getXHR();
	xmlhttp.onreadystatechange=callback;
	xmlhttp.open(httpmethod, endpoint, true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(message);
}

function responseCallback(){
	//console.log("callback called. Status: "+this.readyState);
	if (this.readyState==this.DONE){
		this.onreadystatechange = null;
		if(this.status==200){
			console.log("returned ok");
		}else{
			console.log("abnormal response: "+this.status);
		}
	}
}

function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}

var aa;

function init(){
	if(window['AspectAnalyticsObject']){
		aa=window['AspectAnalyticsObject']
	}
	console.log('setting timeout');
	window.setTimeout('checkQueue()', 0);
}

function checkQueue(){
	console.log('checkQueue');
	if(aa && aa.q && aa.q.shift){
		var elem = aa.q.shift();
		var command = elem.shift()||elem;
		
		switch(command){
			case 'test':
				console.log('setting timeout');
				window.setTimeout(function(){console.log('"test" + '+arrayToString(elem, ' ')+' executed')}, 0);
				break;
			default:
		}
	}
}

function arrayToString(myArray, delimiter){
	
	var str = "";
	
	if(!isArray(myArray) || (typeof delimter != 'string')){
		throw "invalid parameter(s)";
	}
	
	for(var i=0; i<myArray.length-1; i++){
		str += myArray[i].toString() + delimiter;
	}
	
	str += myArray[myArray.length-1].toString();
	
	return str;
}

function isArray(myArray) {
    return myArray.constructor.toString().indexOf("Array") > -1;
}

function test(){
	/*walkTheDOM(document.body, function(node){
		node.innerHTML += "hello world";
	});*/ //works fine
	
	/*walkTheDOM(document.body, function(node){
		console.log(node.nodeName);
	});*/ //works fine
	
	walkTheDOM(document.body, function(node){
		if(node.nodeName == "BUTTON"){
			buttonInit(node);
		}
	})
};

function appendAction(func1, func2){
	if(func1 == null){
		return func2;
	}
	var old = func1;	//store as different reference to stop infinite recursion
	return function(param){old(param); func2(param)};
};

function buttonInit(node){
	logMouseEvents(node);
}

function logMouseEvents(node){
	node.onclick		=	appendAction(node.onclick, function(){sendEvent(node.innerHTML+":onclick")});
	node.oncontextmenu		=	appendAction(node.oncontextmenu, function(){sendEvent(node.innerHTML+":oncontextmenu")});
	node.ondblclick		=	appendAction(node.ondblclick, function(){sendEvent(node.innerHTML+":ondblclick")});
	node.onmousedown		=	appendAction(node.onmousedown, function(){sendEvent(node.innerHTML+":onmousedown")});
	node.onmouseenter		=	appendAction(node.onmouseenter, function(){sendEvent(node.innerHTML+":onmouseenter")});
	node.onmouseleave		=	appendAction(node.onmouseleave, function(){sendEvent(node.innerHTML+":onmouseleave")});
	//node.onmousemove		=	appendAction(node.onmousemove, function(){sendEvent(node.innerHTML+":onmousemove")});
	//node.onmouseover		=	appendAction(node.onmouseover, function(){sendEvent(node.innerHTML+":onmouseover")});
	//node.onmouseout		=	appendAction(node.onmouseout, function(){sendEvent(node.innerHTML+":onmouseout")});
	node.onmouseup		=	appendAction(node.onmouseup, function(){sendEvent(node.innerHTML+":onmouseup")});
}

init();