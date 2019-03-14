package Barcode;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

public class Barcode_PDF {

    public static void createPDF(String image_name,String myString) {

        try {
            Code128Bean code128 = new Code128Bean();
            code128.setHeight(15);
            code128.setModuleWidth(0.3);
            code128.setQuietZone(10);
            code128.doQuietZone(true);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
            code128.generateBarcode(canvas, myString);
            canvas.finish();
            //zapis v file
            FileOutputStream fos = new FileOutputStream("/Users/andrejavbelj/IdeaProjects/vaja1/"+image_name);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            System.out.println("Prislo je do napake pri zapisu BARCODE");
        }
    }
}
