public class Obra{

    private String titulo;
    private String artista;
    private String TipoObra;
    private String Local;
    private int ano;
    
    public Obra(String titulo, String artista, String tipoObra, String local, int ano) {
        this.titulo = titulo;
        this.artista = artista;
        TipoObra = tipoObra;
        Local = local;
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
        return TipoObra;
    }

    public void setTipoObra(String tipoObra) {
        TipoObra = tipoObra;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    @Override
    public String toString() {
        return super.toString() + titulo + "," + artista + "," + TipoObra + "," + Local + "," + ano + ".";
        
    }

    public static Obra fromString(String linha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fromString'");
    }
}