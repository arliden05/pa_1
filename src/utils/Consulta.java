package utils;

public class Consulta {
    String destino;
    String fecha_ida;
    String fecha_vuelta;

    public Consulta(String destino, String fecha_ida, String fecha_vuelta) {
        this.destino = destino;
        this.fecha_ida = fecha_ida;
        this.fecha_vuelta = fecha_vuelta;
    }

    @Override
    public String toString() {
        return "consulta: { destino: \""+destino+"\", fecha_ida: \""+fecha_ida+"\", fecha_vuelta: \""+fecha_vuelta+"\" }";
    }
}
