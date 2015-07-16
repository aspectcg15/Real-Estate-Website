(function(a){
	var scriptElem=document.createElement('script');	//add script tag so we can async load our main code
	scriptElem.async=1;
	scriptElem.src=a;	//a is the location of our script
	scriptElem.contentType="application/javascript";
	var firstScriptTag=document.getElementsByTagName('script')[0];
	firstScriptTag.parentNode.insertBefore(scriptElem,	firstScriptTag);	//add the dynamically created script tag to the DOM
	})('/assets/javascripts/AJAX sender code v2.js');