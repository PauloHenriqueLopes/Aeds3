import java.io.RandomAccessFile;


public class Main {
    public static void main(String[] args) {
        Livro l1 = new Livro(1, "teste1", "teste1", "25/11/2004", 50.25F);
        Livro l2 = new Livro(2, "teste2", "teste2", "01/09/2003", 15.2F);
        Livro l3 = new Livro(3, "teste3", "teste3", "21/05/2014", 25F);

        RandomAccessFile arq;

        byte[] ba;
        try{

            //Escrita
            arq = new RandomAccessFile("dados/livros.db", "rw");

            long p1 = arq.getFilePointer();
            ba = l1.toBytes();
            arq.writeInt(ba.length);
            arq.write(ba);

            long p2 = arq.getFilePointer();
            ba = l2.toBytes();
            arq.writeInt(ba.length);
            arq.write(ba);
            
            long p3 = arq.getFilePointer();
            ba = l3.toBytes();
            arq.writeInt(ba.length);
            arq.write(ba);

            //Leitura
            Livro l4 = new Livro();
            Livro l5 = new Livro();
            Livro l6 = new Livro();
            int tam;

            arq.seek(p3);
            tam = arq.readInt();
            ba = new byte[tam];
            arq.read(ba);
            l4.fromByteArray(ba);

            arq.seek(p1);
            tam = arq.readInt();
            ba = new byte[tam];
            arq.read(ba);
            l5.fromByteArray(ba);

            arq.seek(p2);
            tam = arq.readInt();
            ba = new byte[tam];
            arq.read(ba);
            l6.fromByteArray(ba);

            System.out.println(l4);
            System.out.println(l5);
            System.out.println(l6);

            arq.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
        
            
    }
}
