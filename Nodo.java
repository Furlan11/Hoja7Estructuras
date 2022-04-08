import java.util.ArrayList;

public class Nodo implements Association<String, String[]> {
    
    // Atributos
    public Nodo left;
    public Nodo right;
    public String root;
    public String[] value = new String[3];

    /**
     * Constructor
     * @param newValue, idiom
     */
    public Nodo(ArrayList<String> newValue, int idiom){
        
        this.root = newValue.get(idiom); 
        this.value[0] = this.root;
       
        for (int i = 0; i < newValue.size(); i++) { 
            this.value[i] = newValue.get(i);
        }
    }

    @Override
    public String[] getValue() {
        return this.value;
    }

    @Override
    public String getLenguaje(int len) {
        return this.value[len];
    }

	public Object getLeft() {
		return left;
	}

	public Object getRight() {
		return right;
	}
    
    
}
