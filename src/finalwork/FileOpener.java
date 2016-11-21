/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalwork;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author PrinceOfNightmareH
 */
public class FileOpener {
        public File openFile() throws IOException{
        File file = null;
        final JFileChooser fc = new JFileChooser();
        String fileName = null;
        int response = fc.showOpenDialog(null);

        if (response == fc.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            fileName = fc.getSelectedFile().toString();
            //System.out.println(fileName);

        } else {
            System.out.println("File was not opened!");
        }
        return file;
    }
}
