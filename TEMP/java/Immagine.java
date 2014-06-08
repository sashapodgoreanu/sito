public class Immagine {
	private int id;
	private String url;
	private String descrizione;
	private int numVis;
	private date dataCaricamento;
	private Dimension dim;
	public Notizia immagini;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getNumVis() {
		return this.numVis;
	}

	public void setNumVis(int numVis) {
		this.numVis = numVis;
	}

	public date getDataCaricamento() {
		return this.dataCaricamento;
	}

	public void setDataCaricamento(date dataCaricamento) {
		this.dataCaricamento = dataCaricamento;
	}

	public Dimension getDim() {
		return this.dim;
	}

	public void setDim(Dimension dim) {
		this.dim = dim;
	}
}