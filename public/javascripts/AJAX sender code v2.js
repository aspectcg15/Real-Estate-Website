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
	return xmlhttp;
}

function sendEvent(param_event){
	event = param_event;
	time = new Date().getTime();
	
	var xmlhttp = getXHR();
	xmlhttp.onreadystatechange=defaultCallback;
	xmlhttp.open("POST", "/test3", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("event="+event+"&time="+time);
}

function sendAJAX(httpmethod, endpoint, message, callback, async){	
	var xmlhttp = getXHR();
	xmlhttp.onreadystatechange=callback;
	
	if(async == undefined || async == null) async = true;
	
	xmlhttp.open(httpmethod, endpoint, async);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(message);
}

function defaultCallback(){
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

function attachSendNavigateHit(node){
	var callback = defaultCallback;
	var endpoint ='/anchorHit';
	var method = 'POST';
	node.onclick = function(){ sendNavigateHit(method, endpoint, node.href, getUserId(), callback);};
}

function attachSendRatingHit(node){
	var callback = defaultCallback;
	
	var id = node.getAttribute('id');
	if(id){
		var user_id = getUser_id(id);
		var product_id = getProduct_id(id);
		var rating = getRating(id);
		
		if(node){
			node.onclick = function(){
				if(node.onclick){
					var oldFunction = node.onclick;
				}
				
				return function(){
					oldFunction&&oldFunction(arguments);
					sendRatingHit(user_id, product_id, rating, callback);
				}
			}();
		}
	}
}

function getUser_id(id){
	return parseIdFor(id, 'user_id');
}

function getProduct_id(id){
	return parseIdFor(id, 'product_id');
}

function getRating(id){
	return parseIdFor(id, 'rating');
}

function parseIdFor(id, key){
	var tokens=id.split(' ');
	for(var i=0; i<tokens.length; i++){
		var keyVal = tokens[i].split('=');
		if(keyVal&&keyVal[0]==key){
			return keyVal[1]||null;
		}
	}
}

function sendRatingHit(user_id, product_id, rating, callback){
	var endpoint ='/ratingHit';
	var method = 'POST';
	sendAJAX(method, endpoint, 'user_id='+user_id+'&product_id='+product_id+'&rating='+formatDouble(rating), callback);
}

function sendNavigateHit(method, endpoint, href, user_id, callback){
	sendAJAX(method, endpoint, 'href='+href+'&referrer='+window.location+'&user_id='+user_id+'&time='+(new Date().getTime()), callback, false);
}

function setupAttachSendRatingHit(){
	var spans = document.getElementsByClassName('rating');
	for(var i=0; i< spans.length; i++){
		var children = spans[i].children;
		for(var j=0; j<children.length; j++){
			if(isButton(children[j])){
				attachSendRatingHit(children[j]);
			}
		}
	}
}

/*function attachAppendUserId(node){
	if(node){
		node.onclick = function(){
			
			if(node.onclick){
				console.log(typeof node.onclick);
				var oldFunction = node.onclick;
			}
			
			return function(){
				oldFunction(arguments);
				appendUserId(node);
			}
		}();
	}
}//*/

function appendUserId(target){
	if(target){
		if(!/\?.*user_id *=/.test(target)){
			if(target.indexOf('?')!=-1){
				target += '&user_id='+getUserId();
			}else{
				target += '?user_id='+getUserId();
			}
		}
	}
	
	return target;
}

function getUserId(){
	var temp = document.getElementById('user_id_textbox');
	if(temp) return temp.value;
	else return 0;	//debug default user_id
}

function isButton(node){
	return (node.nodeName == "BUTTON");
}

function setUserInQuery(target){
	target = appendUserId(target);
	var callback = defaultCallback;
	var endpoint ='/anchorHit';
	var method = 'POST';
	
	sendNavigateHit(method, endpoint, target, getUserId(), callback);
	
	//console.log("location.assign");
	location.assign(target);
}

function setupAnchor(node){
	if(node&&node.target){
		node.onclick = function(){console.log("Cleeeek!"); setUserInQuery(node.target);};
	}
}

function formatDouble(number){
	if(/\d+/) number = number+".0";
	return number;
}

function init(){
	//console.log('init');
	walkTheDOM(document.body, function(node){
		//console.log(node.nodeName);
		if(node.nodeName == "A"){
			//attachAppendUserId(node);
			setupAnchor(node);
		}//*/
	});
	//console.log('setupAttachSendRatingHit');
	setupAttachSendRatingHit();
}