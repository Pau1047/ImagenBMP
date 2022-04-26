
import java.io.*;

public class TransformaImagen {

    File f = null;

    public TransformaImagen(File fEnt) {

        if (fEnt.exists() && fEnt.getName().split("\\.")[1] .equals("bmp")) {
            this.f = fEnt;
        } else {
            System.out.println("O el fichero no existe o la extension no es la correcta");
        }
    }

    public void transformaNegativo() throws IOException {

        BufferedInputStream bis = new BufferedInputStream( new FileInputStream(f));
        File ruta = new File("resources/" + getNombreSinExtension() + "_n.bmp");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(ruta));

        bos.write(bis.readNBytes(54));
        int bytes = bis.read();
        while (bytes != -1) {
            bos.write(255 - bytes);
            bytes = bis.read();
        }
        bis.close();
        bos.close();
    }

    public void transformaOscuro() throws IOException {

        // Transformar a una imagen más oscura y guardar como *_o.bmp


    }


    public void transformaBlancoNegro() throws IOException {

        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp

    }

    private String getNombreSinExtension() {

         String[] file = f.getName().split("\\.");
         String name = file[0];
         return name;
    }

}
