public class Obra {

    private String titulo;
    private String artista;
    private String tipoObra;
    private String local;
    private int ano;
    
    public Obra(String titulo, String artista, String tipoObra, String local, int ano) {
        this.titulo = titulo;
        this.artista = artista;
        this.tipoObra = tipoObra;
        this.local = local;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getTipoObra() {
        return tipoObra;
    }

    public void setTipoObra(String tipoObra) {
        this.tipoObra = tipoObra;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    @Override
    public String toString() {
        return titulo + ", " + artista + ", " + tipoObra + ", " + local + ", " + ano + "\n";
    }
}