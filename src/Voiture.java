class Voiture {
    private String marque;
    private int annee;
    private Compagnie compagnie;
       
	public Voiture(String name, int age, Compagnie compagnie) {
		this.marque = name;
		this.annee = age;
		this.setCompagnie(compagnie);
	}
	public String getName() {
		return marque;
	}
	public void setName(String name) {
		this.marque = name;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int age) {
		this.annee = age;
	}
	public Compagnie getCompagnie() {
		return compagnie;
	}
	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}

}
