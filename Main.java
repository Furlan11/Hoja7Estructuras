import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
	 public static void main (String[] args) { 
		 Scanner teclado= new Scanner(System.in);	
		   JFileChooser file = new JFileChooser();
		    Traductor traductor = new Traductor();
		    boolean llave= true;
		    
		    
		    
		    int r1 = file.showOpenDialog(null); 
            if (r1 == JFileChooser.APPROVE_OPTION) {
            	File archivo1 = file.getSelectedFile();
            	String path1 = archivo1.getAbsolutePath();
            	JOptionPane.showMessageDialog(null, "Archivo: " + path1 + " abierto exitosamente!");
        		traductor.crearDic(path1);
        		System.out.print("Los diccionarios fueron cargados exitosamente!");
        		
            }
		    while(llave== true){
		    	
		    	System.out.println("Menu \n"
		    			+ "1.ver el diccionario ordenado \n"
		    			+ "2. Traducir archivo\n"
		    			+ "3. salir \n"
		    			
		    			);
		    	int op1=teclado.nextInt();
		    	
		    	if(op1==1) {
		    		System.out.print("Tipo de diccionario"
		    				+ " \n 1. Ingles "
		    				+ "\n 2. Español"
		    				+ " \n 3. Frances"
		    				);
		    		int op2=teclado.nextInt();
		    		traductor.mostrarOrden(op2);
		    	}
		    	
		    	if(op1==2) {
		    		System.out.print("Idioma en el que se encuentra el documento "
		    				+ " \n 1. Ingles"
		    				+ " \n 2. Español"
		    				+ " \n 3. Frances"
		    				);
		    		int op2=teclado.nextInt();
	            	
	            	System.out.print("\n---Idioma al que desea traducirlo --- \n 1. Ingles \n 2. Español \n 3. Frances \n 4. Salir \n");
	            	int op3=teclado.nextInt();
	            	
	            	int r2 = file.showOpenDialog(null);
	                if (r2 == JFileChooser.APPROVE_OPTION) {
		            	File archivo2 = file.getSelectedFile();
		            	String path2 = archivo2.getAbsolutePath();
		            	JOptionPane.showMessageDialog(null, "Archivo: " + path2 + " abierto exitosamente!"); 
		        		traductor.traducir(path2, op2, op3); 
		    		
		    	}
		    }
		    	if(op1==3) {
		    		llave=false;
		    	}
		    
		    
		    
		    
	 }
}}
