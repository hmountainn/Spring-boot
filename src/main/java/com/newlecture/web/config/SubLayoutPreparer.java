package com.newlecture.web.config;

import java.util.Map;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

public class SubLayoutPreparer implements ViewPreparer {

	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		
		Map<String, Object> model = tilesContext.getContext("request");
		/* model.put("title", ""); */
		model.put("data", "default data");
		Object title = model.get("title");
		if(title==null)
			model.put("title", "기본제목");
	}
	
}
