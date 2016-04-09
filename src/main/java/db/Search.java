package db;

import java.io.Serializable;
import java.util.Date;

public class Search implements Serializable {

	private static final long serialVersionUID = 231L;

	private Long id;
	private String searchPhrase;
	private Integer number;
	Date date;
	private Long chosenOfferId;

	public Search() {
	}

	public Search(String searchPhrase, Integer number, Date date) {
		this.searchPhrase = searchPhrase;
		this.number = number;
		this.date = date;
	}

	public String getSearchPhrase() {
		return searchPhrase;
	}

	public void setSearchPhrase(String searchPhrase) {
		this.searchPhrase = searchPhrase;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getChosenOfferId() {
		return chosenOfferId;
	}

	public void setChosenOfferId(Long chosenOfferId) {
		this.chosenOfferId = chosenOfferId;
	}
}
