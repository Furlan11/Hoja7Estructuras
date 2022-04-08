import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Traductor {
	private BinarySearchTree dicEsp = new BinarySearchTree();
	private BinarySearchTree dicI = new BinarySearchTree();
	private BinarySearchTree dicFra = new BinarySearchTree(); 
	private Nodo nodoE; 
	private Nodo nodoS;
	private Nodo nodoF; 
	
	
	
	public ArrayList<String> crearDic(String path1){
		ArrayList<String> linea = new ArrayList<String>(); 
        try{
            FileReader lec; //define variables para lectura de archivo
            BufferedReader buff;
            String datos;
            
            	
                lec = new FileReader(path1);
                buff = new BufferedReader(lec);
                datos= buff.readLine();
                while (datos!=null){
                   String partes[] = datos.split(",");
                   for (int i=0; i<partes.length; i++){ 
                       linea.add(partes[i].toLowerCase());                     
                   }
                   
                   agregarDic(linea);
                                  
                   linea.clear(); 
                   datos= buff.readLine(); 
                   
                }
                buff.close(); 
        }
        catch( IOException | NumberFormatException e){

        }
        return linea;
    }
	
	/*
	 * Metodo agregarDic
	 * @param linea
	 * @return String
	 */
	public String agregarDic(ArrayList<String> linea) {
		nodoE = new Nodo(linea, 0); //crea el nodo junto con la asociacion para ingles
        nodoS = new Nodo(linea, 1);//crea el nodo junto con la asociacion para español
        nodoF = new Nodo(linea, 2);//crea el nodo junto con la asociacion para frances
        
        
        
        dicEsp.Insert(nodoE);
        dicI.Insert(nodoS);
        dicFra.Insert(nodoF);
		
        return "Palabra agregada exitosamente!";
	}
	
	/*
	 * Metodo mostrarOrden
	 * @param option
	 * @return void
	 */
	public void mostrarOrden(int option) {
		
			if(option== 1){
				System.out.println(" Diccionario Inglés in order\n"
			+dicEsp.InOrder(dicEsp.getRoot())); }
			if(option== 2){
				System.out.println("-Diccionario Español in order"+dicI.InOrder(dicI.getRoot()));
			}
			if(option== 3){ 
				System.out.println("Diccionario Francés in order\n"+dicFra.InOrder(dicFra.getRoot()));
			}
			else{
               
            	System.out.print("\nDebe ingresar una respuesta correcta");
            	}
			
		}
		
	
	

	
	/*
	 * Metodo traducir
	 * @param path1, op2, op3
	 */
	public void traducir (String path1, int op2, int op3){
		int opc2= op2; 
		int opc3= op3;
		ArrayList<String> linea = new ArrayList<String>(); 
        try{
            FileReader lec; //variables para lectura de archivo
            BufferedReader buff;
            String datos;
            
        
                lec = new FileReader(path1);
                buff = new BufferedReader(lec);
               
                datos= buff.readLine();
               
                while (datos!=null){
                  
                   String partes[] = datos.split(" ");
                   for (int i=0; i<partes.length; i++){
                       linea.add(partes[i].toLowerCase());        
                   }
                  
                   	ArrayList<String> traduccion = buscarTraduccion(linea, opc2, opc3); 
	        		for(int i=0; i < traduccion.size(); i++){ 
	        	            System.out.print(traduccion.get(i)+" "); 
	        	    }
	        		System.out.print("\n"); 
	        		linea.clear(); 
	        		datos= buff.readLine(); //evalua la siguiente linea
                   
                }
                buff.close();
        }
        catch( IOException | NumberFormatException e){

        }
      
    }
	
	/*
	 * Metodo buscarTraduccion
	 * @param linea, op2, op3
	 */
	public ArrayList<String> buscarTraduccion (ArrayList<String> linea, int op2, int op3){
		ArrayList<String> texto = new ArrayList<String>();
		
		for (int i=0; i<linea.size(); i++ ) { 
			switch(op2) {
				case 1:
					switch(op3) {
						case 1: 
						
							System.out.print("\nSu texto original ya se encuentra en inglés");
							break;
				
						case 2: //se desea pasar a español
							if (dicEsp.find(linea.get(i))!= null) {
						
								String[] trad = dicEsp.find(linea.get(i));
								texto.add(trad[1]);
							}else {
								texto.add("*"+linea.get(i)+"*");
							}
							break;
				
						case 3:  //se desea pasar a fracés
							if (dicEsp.find(linea.get(i))!= null) {
						
								String[] trad = dicEsp.find(linea.get(i));
								texto.add(trad[2]);
							}else {
								texto.add("*"+linea.get(i)+"*");
							}
							break;
						case 4: 
							System.exit(0);
						default : 
							System.out.print("\nDebe seleccionar una respuesta correcta"); 
							break;
					}
			}
			if (op2==2) { 
				if(op3==1) { 
					if (dicI.find(linea.get(i))!= null) { 
						
						String[] trad = dicI.find(linea.get(i));
						texto.add(trad[0]);
					}else {
						texto.add("*"+linea.get(i)+"*");
					}
					
				}
				else if (op3==2) {
					System.out.print("\nSu texto original ya se encuentra en español");
				}
				else if (op3==3) { 
					if (dicI.find(linea.get(i))!= null) {
				
						String[] trad = dicI.find(linea.get(i));
						texto.add(trad[2]);
					}else {
						texto.add("*"+linea.get(i)+"*");
					}
				}else {
					System.out.print("\nDebe seleccionar una respuesta correcta");
				}
			}
			if (op2==3) { 
				if(op3==1) {
					if (dicFra.find(linea.get(i))!= null) { 
						
						String[] trad = dicFra.find(linea.get(i));
						texto.add(trad[0]);
					}else {
						texto.add("*"+linea.get(i)+"*");
					}
					
				}
				else if (op3==2) {
					if (dicFra.find(linea.get(i))!= null) {
						
						String[] trad = dicFra.find(linea.get(i));
						texto.add(trad[1]);
					}else {
						texto.add("*"+linea.get(i)+"*");
					}
					
				}
				else if (op3==3) {
					System.out.print("\nSu texto original ya se encuentra en francés");
				}else {
					System.out.print("\nDebe seleccionar una respuesta correcta");
				}
			}
		}
     	
		return texto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
