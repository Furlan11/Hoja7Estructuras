

public class BinarySearchTree implements BinaryTree<Nodo> {

    // Atributos
    private Nodo root; 
    private int count; 

    
    public BinarySearchTree(){
        this.count = 0;
        this.root = null;
    }

    @Override
    public void Insert(Nodo _new) {

        if (root == null){ 

            root = _new;
            count++;
            
        } else {
            try {
                insertAux(root, _new);
            } catch (Exception e) {
                
            }
        }
    }

    /**
     * Metodo: insertAux
     * @param actual, _new
     * @return void
     */
    private void insertAux(Nodo actual, Nodo _new ) throws Exception{

        if (actual != null) { 

            if (actual.root.compareTo(_new.root) > 0){ 

                if (actual.left == null){ 
                    actual.left = _new; 
                    count++;

                } else {
                    try{
                        insertAux(actual.left, _new);
                    } catch(Exception e){
                        
                    }
                }
                
            } else if (actual.root.compareTo(_new.root) < 0){

                if (actual.right == null){ 
                    actual.right = _new;
                    count++;

                } else {
                    try{
                        insertAux(actual.right, _new);
                    } catch(Exception e){
                    }
                }

            } else{ 
                throw new Exception("El valor ya existe en el arbol"); 
            }
        }
    }

    @Override
    public String[] find(String key) {

        if (root == null){ 
            return null;

        } else {
            return findAux(key, root); 
        }
    }

    /**
     * Metodo: findAux
     * @param key, actual
     * @return String[]
     */
    private String[] findAux(String key, Nodo actual) {

        if (actual.root.compareTo(key) > 0){

            if (actual.left == null){ 
                return null;

            } else { 

                try{
                   return findAux(key, actual.left); 

                } catch(Exception e){
                    return null;
                }
            }

        } else if (actual.root.compareTo(key) < 0){ 

            if (actual.right == null){ 
                return null;

            } else {
               return findAux(key, actual.right);
            }

        
        } else{
            return actual.value; //si el valor no existe
        }
    }

    @Override
    public String InOrder(Nodo actual) {

        String value = ""; 
        if (actual != null){

            
            value = InOrder(actual.left);

            String[] temp_array = actual.value;
            String[] array = new String[3];
            array[0] = actual.root;
            int i = 1;

            for (String val : temp_array) {
                if (!val.equals(actual.root)){
                    array[i] = val;
                    i++;
                }
            }

            if (array[0].equalsIgnoreCase("homework")){ 
                value += array[0] + "\t";
            } else {
                value += array[0] + "\t\t";
            }

            if (array[1].equalsIgnoreCase("homework")){
                value += array[1] + "\t";
            } else {
                value += array[1] + "\t\t";
            }
            value += array[2] + "\n";

           
            value += InOrder(actual.right);
        } 
        return value;
    }


    @Override
    public String PreOrder(Nodo actual) {
        return null; 
    }

    @Override
    public String PostOrder(Nodo actual) {
        
        return null; 
    }

    @Override
    public boolean empty() {
        return count == 0; 
    }

    @Override
    public int count() {
        return count; //
    }

    @Override
    public Nodo Delete(String key) {
        return null; 
    }

    /**
     * Metodo: getRoot
     * @return Nodo
     */
    public Nodo getRoot() {
        return root;
    }

}
