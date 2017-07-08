package com.test.gamelist.home.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.gamelist.home.dao.HomeDAO;
import com.test.gamelist.home.dto.GameList;

public class HomeServiceImpl implements HomeService{
	
	@Autowired
	private HomeDAO homeDAO;

	@Override
	public List<GameList> getGameList(GameList game) {
		return homeDAO.getGameList(game);
	}

	@Override
	public List<String> getTitleList() {
		return homeDAO.getTitleList();
	}

}
