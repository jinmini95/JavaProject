package project;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLReader {
 private Document XMLDoc;
 public static String E_BLOCKGAME = "BlockGame";
 public static String E_SCREEN = "Screen";
 public static String E_GAMEPANEL = "GamePanel";
 public static String E_BG = "Bg";
 public static String E_SIZE = "Size";
 public static String E_BLOCK = "Block";
 public static String E_OBJ = "Obj";
 public static String E_WEAPON = "Weapon";
 public static String E_CHAR = "Character";
 public static String E_CHAR1 = "Characterobj1";
 public static String E_CHAR2 = "Characterobj2";
 private Node blockGameElement = null;
 private Node screenElement = null;
 private Node gamePanelElement = null;
 private Node bgElement = null;
 private Node weaponElement = null;
 private Node charElement = null;
 private PrintWriter out;

 public Node getBlockGameElement() {
     return this.blockGameElement;
 }

 public Node getScreenElement() {
     return this.screenElement;
 }

 public Node getGamePanelElement() {
     return this.gamePanelElement;
 }

 public Node getBgElement() {
     return this.blockGameElement;
 }

 public Node getWeaponElement() {
     return this.weaponElement;
 }

 public Node getCharElement() {
     return this.charElement;
 }

 public XMLReader(String XMLFile) {
     this.read(XMLFile);
     this.process(this.XMLDoc);
     ByteArrayOutputStream byteStream = null;

     try {
         byteStream = new ByteArrayOutputStream();
         OutputStreamWriter writer = new OutputStreamWriter(byteStream, "UTF-8");
         this.out = new PrintWriter(writer, true);
     } catch (IOException var4) {
         return;
     }

     new DEBUG_echo(this.XMLDoc, this.out);
     this.out.flush();
 }

 private void read(String XMLFile) {
     DocumentBuilderFactory factory = null;
     DocumentBuilder builder = null;
     factory = DocumentBuilderFactory.newInstance();
     factory.setIgnoringComments(false);
     factory.setIgnoringElementContentWhitespace(false);

     try {
         builder = factory.newDocumentBuilder();
         OutputStreamWriter errStreamWriter = new OutputStreamWriter(System.err, "UTF-8");
         builder.setErrorHandler(new XMLReader.XMLBuilderErrorHandler(new PrintWriter(errStreamWriter, true)));
         File f = new File(XMLFile);
         this.XMLDoc = builder.parse(f);
     } catch (SAXException var6) {
         Exception x = var6;
         if (var6.getException() != null) {
             x = var6.getException();
         }

         ((Exception)x).printStackTrace();
     } catch (ParserConfigurationException var7) {
         var7.printStackTrace();
     } catch (IOException var8) {
         var8.printStackTrace();
     }

 }

 public void process(Node parentNode) {
     for(Node node = parentNode.getFirstChild(); node != null; node = node.getNextSibling()) {
         if (node.getNodeType() == 1) {
             if (node.getNodeName().equals(E_BLOCKGAME)) {
                 this.blockGameElement = node;
             } else if (node.getNodeName().equals(E_SCREEN)) {
                 this.screenElement = node;
             } else if (node.getNodeName().equals(E_BG)) {
                 this.bgElement = node;
             } else if (node.getNodeName().equals(E_GAMEPANEL)) {
                 this.gamePanelElement = node;
             } else if (node.getNodeName().equals(E_BLOCK)) {
                 boolean var3 = false;
             } else if (node.getNodeName().equals(E_WEAPON)) {
                 this.weaponElement = node;
             } else if (node.getNodeName().equals(E_CHAR)) {
                 this.charElement = node;
             } else {
                 node.getNodeName().equals(E_OBJ);
             }

             this.printNode(node);
             this.process(node);
         }
     }

 }

 void printNode(Node element) {
     System.out.print(element.getNodeName() + " ");
     NamedNodeMap attrs = element.getAttributes();

     for(int i = 0; i < attrs.getLength(); ++i) {
         Node attr = attrs.item(i);
         String name = attr.getNodeName();
         String value = attr.getNodeValue();
         System.out.print(name + "=" + value + " ");
     }

     System.out.println();
 }

 public static Node getNode(Node parentNode, String nodeName) {
     Node node = null;

     for(node = parentNode.getFirstChild(); node != null; node = node.getNextSibling()) {
         if (node.getNodeType() == 1) {
             if (node.getNodeName().equals(nodeName)) {
                 return node;
             }

             Node n = getNode(node, nodeName);
             if (n != null) {
                 return n;
             }
         }
     }

     return node;
 }

 public static String getAttr(Node element, String attrName) {
     NamedNodeMap attrs = element.getAttributes();

     for(int i = 0; i < attrs.getLength(); ++i) {
         Node attr = attrs.item(i);
         String name = attr.getNodeName();
         if (name.equals(attrName)) {
             return attr.getNodeValue();
         }
     }

     return null;
 }

 class XMLBuilderErrorHandler implements ErrorHandler {
     private PrintWriter out;

     XMLBuilderErrorHandler(PrintWriter out) {
         this.out = out;
     }

     private String getParseExceptionInfo(SAXParseException spe) {
         String systemId = spe.getSystemId();
         if (systemId == null) {
             systemId = "null";
         }

         String info = "URI=" + systemId + " Line=" + spe.getLineNumber() + ": " + spe.getMessage();
         return info;
     }

     public void warning(SAXParseException spe) throws SAXException {
         this.out.println("Warning: " + this.getParseExceptionInfo(spe));
     }

     public void error(SAXParseException spe) throws SAXException {
         String message = "Error: " + this.getParseExceptionInfo(spe);
         throw new SAXException(message);
     }

     public void fatalError(SAXParseException spe) throws SAXException {
         String message = "Fatal Error: " + this.getParseExceptionInfo(spe);
         throw new SAXException(message);
     }
 }


}
