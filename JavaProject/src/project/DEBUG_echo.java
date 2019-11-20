package project;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import java.io.PrintWriter;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Entity;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

class DEBUG_echo {
 private PrintWriter out;
 private int indent;

 DEBUG_echo(Document d, PrintWriter w) {
     this.out = w;
     this.echo(d);
 }

 private void outputIndentation() {
     for(int i = 0; i < this.indent; ++i) {
         this.out.print("   ");
     }

 }

 private void printlnCommon(Node n) {
     this.out.print(" nodeName=\"" + n.getNodeName() + "\"");
     String val = n.getNamespaceURI();
     if (val != null) {
         this.out.print(" uri=\"" + val + "\"");
     }

     val = n.getPrefix();
     if (val != null) {
         this.out.print(" pre=\"" + val + "\"");
     }

     val = n.getLocalName();
     if (val != null) {
         this.out.print(" local=\"" + val + "\"");
     }

     val = n.getNodeValue();
     if (val != null) {
         this.out.print(" nodeValue=");
         if (val.trim().equals("")) {
             this.out.print("[WS]");
         } else {
             this.out.print("\"" + n.getNodeValue() + "\"");
         }
     }

     this.out.println();
 }

 protected void echo(Node n) {
     this.outputIndentation();
     int type = n.getNodeType();
     switch(type) {
     case 1:
         this.out.print("ELEM:");
         this.printlnCommon(n);
         NamedNodeMap atts = n.getAttributes();
         this.indent += 2;

         for(int i = 0; i < atts.getLength(); ++i) {
             Node att = atts.item(i);
             this.echo(att);
         }

         this.indent -= 2;
         break;
     case 2:
         this.out.print("ATTR:");
         this.printlnCommon(n);
         break;
     case 3:
         this.out.print("TEXT:");
         this.printlnCommon(n);
         break;
     case 4:
         this.out.print("CDATA:");
         this.printlnCommon(n);
         break;
     case 5:
         this.out.print("ENT_REF:");
         this.printlnCommon(n);
         break;
     case 6:
         this.out.print("ENT:");
         this.printlnCommon(n);
         break;
     case 7:
         this.out.print("PROC_INST:");
         this.printlnCommon(n);
         break;
     case 8:
         this.out.print("COMM:");
         this.printlnCommon(n);
         break;
     case 9:
         this.out.print("DOC:");
         this.printlnCommon(n);
         break;
     case 10:
         this.out.print("DOC_TYPE:");
         this.printlnCommon(n);
         NamedNodeMap nodeMap = ((DocumentType)n).getEntities();
         this.indent += 2;

         for(int i = 0; i < nodeMap.getLength(); ++i) {
             Entity entity = (Entity)nodeMap.item(i);
             this.echo(entity);
         }

         this.indent -= 2;
         break;
     case 11:
         this.out.print("DOC_FRAG:");
         this.printlnCommon(n);
         break;
     case 12:
         this.out.print("NOTATION:");
         this.printlnCommon(n);
         break;
     default:
         this.out.print("UNSUPPORTED NODE: " + type);
         this.printlnCommon(n);
     }

     ++this.indent;

     for(Node child = n.getFirstChild(); child != null; child = child.getNextSibling()) {
         this.echo(child);
     }

     --this.indent;
 }
}
