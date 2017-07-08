package com.test.gamelist.home.services;

import java.util.List;

import com.test.gamelist.home.dto.GameList;

public interface HomeService {
	
	public List<String> getTitleList();
	
	public List<GameList> getGameList(GameList game);

}
