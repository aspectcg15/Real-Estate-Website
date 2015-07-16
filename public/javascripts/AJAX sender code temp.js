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
	xmlhttp.open("POST", "localhost:9000/test3", true);
	xhr.setRequestHeader("Content-Type","application/json");
    //xhr.setRequestHeader("X-Requested-With","XMLHttpRequest");
    //supported in new browsers...do JSONP based stuff in older browsers...figure out how
    //xhr.setRequestHeader("Access-Control-Allow-Origin","http://geojsonlint.com/");
    xhr.setRequestHeader("Accept","application/json");
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("{}");
}

function sendAJAX(httpmethod, endpoint, message, callback){	
	var xmlhttp = getXHR();
	xmlhttp.onreadystatechange=callback;
	xmlhttp.open(httpmethod, endpoint, true);
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
	var endpoint ='/ratingHit';
	var method = 'POST';
	node.onclick = function(){ sendNavigateHit(method, endpoint, node.href, callback);};
}

function sendNavigateHit(method, endpoint, href, callback){
	sendAJAX(method, endpoint, 'href="'+href+'"', callback);
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
	sendAJAX(method, endpoint, 'user_id="'+user_id+'"&product_id="'+product_id+'"&rating="'+rating, callback);
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
	return temp&&temp.value;
}

function isButton(node){
	return (node.nodeName == "BUTTON");
}

function setUserInQuery(target){
	target = appendUserId(target);
	location.assign(target);
}

function setupAnchor(node){
	if(node&&node.target){
		node.onclick = function(){console.log("Cleeeek!"); setUserInQuery(node.target);};
	}
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

init();