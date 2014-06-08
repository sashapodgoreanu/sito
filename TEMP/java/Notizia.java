import java.util.ArrayList;

public class Notizia {
	private String nome;
	private String testo;
	private int numVis;
	private Date dataCaricamento;
	private int validitaInMesi;
	private int popularita;
	public ArrayList<Immagine> immagini = new ArrayList<Immagine>();

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTesto() {
		return this.testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public int getNumVis() {
		return this.numVis;
	}

	public void setNumVis(int numVis) {
		this.numVis = numVis;
	}

	public Date getDataCaricamento() {
		return this.dataCaricamento;
	}

	public void setDataCaricamento(Date dataCaricamento) {
		this.dataCaricamento = dataCaricamento;
	}

	public int getValiditaInMesi() {
		return this.validitaInMesi;
	}

	public void setValiditaInMesi(int validitaInMesi) {
		this.validitaInMesi = validitaInMesi;
	}

	public int getPopularita() {
		return this.popularita;
	}

	public void setPopularita(int popularita) {
		this.popularita = popularita;
	}

	public static ArrayList<Notizia> getPostInEvidenza() {
		throw new UnsupportedOperationException();
	}

	public static ArrayList<Notizia> getNotiziePopolari() {
		throw new UnsupportedOperationException();
	}

	public boolean save() {
		throw new UnsupportedOperationException();
	}

	public boolean load() {
		throw new UnsupportedOperationException();
	}

	public void getNextNotizia() {
		throw new UnsupportedOperationException();
	}
}