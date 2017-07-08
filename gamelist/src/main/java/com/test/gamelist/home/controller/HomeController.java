package com.test.gamelist.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.GsonBuilder;
import com.test.gamelist.home.dto.GameList;
import com.test.gamelist.home.services.HomeService;

@Controller
@RequestMapping("/gamelist-module")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value="/getGameList", method=RequestMethod.POST)
	public @ResponseBody String getGameList(@RequestBody GameList game){
		String response = null;
		try {
			List<GameList> gameList = homeService.getGameList(game);
			response = new GsonBuilder().disableHtmlEscaping().create().toJson(gameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value="/getTitleList", method=RequestMethod.GET)
	public @ResponseBody String getTitleList(){
		String response = null;
		try {
			List<String> titleList = homeService.getTitleList();
			response = new GsonBuilder().disableHtmlEscaping().create().toJson(titleList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
