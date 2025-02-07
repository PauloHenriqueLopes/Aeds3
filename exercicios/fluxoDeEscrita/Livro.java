import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Livro {
    protected int id;
    protected String nome;
    protected String autor;
    protected String data;
    protected float valor;

    public Livro(int id, String nome, String autor, String data, float valor) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.data = data;
        this.valor = valor;
    }
    
    public Livro() {
        this.id = -1;
        this.nome = "";
        this.autor = "";
        this.data = "";
        this.valor = 0F;
    }
    
    DecimalFormat df = new DecimalFormat("#,##0.00");

    public String toString() {
        return "\nID: " + id +
               "\nTítulo: " + nome + 
               "\nAutor: " + autor +
               "\nData: " + data +
               "\nPreço: R$" + df.format(valor);
    }

    public byte[] toBytes() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(id);
        dos.writeUTF(nome);
        dos.writeUTF(autor);
        dos.writeUTF(data);
        dos.writeFloat(valor);
        return baos.toByteArray();
    }

    public void fromByteArray(byte[] ba) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);
        id = dis.readInt();
        nome = dis.readUTF();
        autor = dis.readUTF();
        data = dis.readUTF();
        valor = dis.readFloat();
    }
}
