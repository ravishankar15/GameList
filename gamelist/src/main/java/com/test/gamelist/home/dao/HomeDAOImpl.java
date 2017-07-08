package com.test.gamelist.home.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.gamelist.home.dto.GameList;

public class HomeDAOImpl implements HomeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<GameList> getGameList(GameList game) {
		List<GameList> gamesList = new ArrayList<>();
		StringBuffer sqlBf = new StringBuffer();
		try {
			sqlBf.append("SELECT * FROM `table 8`");
			if (!(game.getTitle() == null || game.getTitle().equalsIgnoreCase("")
					|| game.getTitle().equalsIgnoreCase("''"))) {
				sqlBf.append(" WHERE TITLE='" + game.getTitle() +"'");
			}
			gamesList = jdbcTemplate.query(sqlBf.toString(), new Object[] {}, new GameListRowMappar());
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gamesList;
	}

	class GameListRowMappar implements RowMapper<GameList> {

		@Override
		public GameList mapRow(ResultSet rs, int rowNum) throws SQLException {
			GameList gamelist = new GameList();
			try {
				gamelist.setTitle(rs.getString("TITLE"));
				gamelist.setPlatform(rs.getString("PLATFORM"));
				gamelist.setScore(rs.getString("SCORE"));
				gamelist.setGenre(rs.getString("GENRE"));
				gamelist.setEditorchoice(rs.getString("EDITORS_CHOICE"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return gamelist;
		}

	}

	@Override
	public List<String> getTitleList() {
		List<String> titleList = new ArrayList<>();
		StringBuffer sqlBf = new StringBuffer();
		try {
			sqlBf.append("SELECT TITLE FROM `TABLE 8`");
			titleList = jdbcTemplate.query(sqlBf.toString(), new Object[] {}, new RowMapper<String>() {

				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getString("TITLE").trim();
				}

			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return titleList;
	}
}
