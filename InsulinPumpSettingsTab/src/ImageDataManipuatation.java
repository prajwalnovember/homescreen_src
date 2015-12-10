import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ImageDataManipuatation {
  public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Canvas Example");
    shell.setLayout(new FillLayout());

    Canvas canvas = new Canvas(shell, SWT.NONE);

    canvas.addPaintListener(new PaintListener() {
      public void paintControl(PaintEvent e) {
        Image image = new Image(display, "yourFile.gif");

        ImageData data = image.getImageData();
        
        data.setPixel(5,5,5);
        
        Image anotherImage = new Image(display, data);
        e.gc.drawImage(anotherImage, 10, 10);
        image.dispose();
      }
    });

    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}