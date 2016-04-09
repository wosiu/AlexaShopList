package db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;

@Component
public class AlexaDAOImpl implements AlexaDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public AlexaDAOImpl() {
	}

	public Long addSearch(final Search search) {
		final String INSERT_SQL =
				"INSERT INTO \"AlexaShopList_search\"(search_phrase, number, date, chosen_offer_id) VALUES(?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
				connection -> {
					PreparedStatement ps =
							connection.prepareStatement(INSERT_SQL, new String[]{"id"});
					ps.setString(1, search.getSearchPhrase());
					ps.setLong(2, search.getNumber());
					ps.setDate(3, new java.sql.Date(search.getDate().getTime()));
					ps.setLong(4, search.getChosenOfferId());
					return ps;
				},
				keyHolder);

		return keyHolder.getKey().longValue();
	}

	public Long addOffer(final Offer offer) {
		final String INSERT_SQL =
				"INSERT INTO \"AlexaShopList_offer\" (price, shop_name, shop_url,shop_product_name, search_id) VALUES (?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
				connection -> {
					PreparedStatement ps =
							connection.prepareStatement(INSERT_SQL, new String[]{"id"});
					ps.setFloat(1, Float.valueOf(offer.getPrice()));
					ps.setString(2, offer.getShopName());
					ps.setString(3, offer.getShopUrl());
					ps.setString(4, offer.getShopProductName());
					ps.setLong(5, offer.getSearchId());
					return ps;
				},
				keyHolder);

		return keyHolder.getKey().longValue();
	}

	@Override
	public void updateSearch(Long idSearch, Long idChosenOffer) {
		final String UPDATE_SQL = "UPDATE \"AlexaShopList_offer\" SET chosen_offer_id = ? WHERE id = ?";
		jdbcTemplate.update(UPDATE_SQL, idChosenOffer, idSearch);
	}
}
