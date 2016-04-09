package db;

public interface AlexaDAO {

	public Long addSearch(Search search);

	public Long addOffer(Offer offer);

	public void updateSearch(Long idSearch, Long idChosenOffer);

}
