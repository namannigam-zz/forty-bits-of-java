package com.stackoverflow.nullpointer.file;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
public class FileDragDemo extends JPanel {

    static FileListTransferHandler objectFileListTransferHandler;

    public static String StringFile = "/Users/xyz/desktop";
    public JList list = new JList();


    public FileDragDemo() {
        list.setDragEnabled(true);
        list.setTransferHandler(new FileListTransferHandler(list));

        add(new JScrollPane(list));

    }

    public static void createAndShowGui() {
        FileDragDemo mainPanel = new FileDragDemo();

        JFrame frame = new JFrame("convertNumbersToName.jdk.handling.FileDragDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }

    public static void main(String[] args) throws Exception {

        //String filestring ="";
        //data = new List;


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
        /*StringFile = FileListTransferHandler.StringFile;
        convertNumbersToName.jdk.handling.PdfEasyManager PdfEasyManagerObject = new convertNumbersToName.jdk.handling.PdfEasyManager ();
        try {
            PdfEasyManagerObject.convertNumbersToName(args);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
            }
        });
    }

    @SuppressWarnings("serial")
    class FileListTransferHandler extends TransferHandler {
        public JList list;
        public File file;
        public List data;
        public String StringFile;

        public FileListTransferHandler(JList list) {
            this.list = list;
        }

        public int getSourceActions(JComponent c) {
            return COPY_OR_MOVE;
        }

        public boolean canImport(TransferSupport ts) {
            return ts.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
        }

        public boolean importData(TransferSupport ts) {
            try {
                @SuppressWarnings("rawtypes")

                List data = (List) ts.getTransferable().getTransferData(
                        DataFlavor.javaFileListFlavor);
                if (data.size() < 1) {
                    return false;
                }// close if

                DefaultListModel listModel = new DefaultListModel();

                for (Object item : data) {

                    File file = (File) item;
                    //file1 = item;
                    listModel.addElement(file);
                    System.out.println("%%%%%%%%%%%file... " + file);
                    StringFile = file.toString();
                    System.out.println("%%%%%%%%%%%com.stackoverflow.nullpointer.string... " + StringFile);
                } // close for
                //String filestring = file.toString();

                list.setModel(listModel);
                return true;

            }// close try
            catch (UnsupportedFlavorException | IOException e) {
                return false;
            }

            //convertNumbersToName.jdk.handling.PdfEasyManager PdfEasyManagerObject = new convertNumbersToName.jdk.handling.PdfEasyManager ();
            //try {
            //PdfEasyManagerObject.convertNumbersToName(args);
            //} catch (IOException e) {
            //e.printStackTrace();
            //}
        }
    }

}