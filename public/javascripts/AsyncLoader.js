(function(a,b){
	window['AspectAnalyticsObject']=b;		//define this as a lookup so that the code we load can look up what object we are using to buffer commands
	window[b]=window[b]||function(){			//function b adds it's arguments to a queue, b.q. This buffers command while the dynamically created script is loading
		(window[b].q=window[b].q||[]).push(arguments);
	};
	window[b].date=1*new Date();	//b.date is the time that this script was loaded
	var scriptElem=document.createElement('script');	//add a script tag to async load our main code
	scriptElem.async=1;
	scriptElem.src=a;	//a is the location of our script
	var firstScriptTag=document.getElementsByTagName('script')[0];
	firstScriptTag.parentNode.insertBefore(scriptElem,	firstScriptTag);	//add the dynamically created script tag to the DOM
	})('/assets/javascripts/AJAX sender code.js', 'aa');	//parameters (location of our main script, name we want to use to interface with it)
	
	aa('test');