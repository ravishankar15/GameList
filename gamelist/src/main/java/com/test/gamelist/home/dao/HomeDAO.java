package com.test.gamelist.home.dao;

import java.util.List;

import com.test.gamelist.home.dto.GameList;

public interface HomeDAO {
	
	public List<String> getTitleList();
	
	public List<GameList> getGameList(GameList game);

}
