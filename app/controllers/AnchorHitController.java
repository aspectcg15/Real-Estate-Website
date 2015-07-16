package controllers;

import models.AnchorHit;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import util.KafkaHelper;

public class AnchorHitController extends Controller {
	public Result handleRequest(){
		Logger.info("Anchor hit received");
		AnchorHit anchorHit = Form.form(AnchorHit.class).bindFromRequest().get();

		if(anchorHit!=null){
			Logger.info("dispatching to kafka: "+anchorHit.toString());
			KafkaHelper.kafka("page_visits", anchorHit);

			Logger.info("dispath sent");
		}else{
			Logger.error("bad request, dispatch not sent");
		}
		
		return ok();
	}
}
