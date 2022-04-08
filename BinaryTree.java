
public interface BinaryTree<E> {

    /**
     * Metodo Insert
     * @param _new
     */
    public void Insert(E _new);

    /**
     * Metodo Delete
     * @param Key
     * @return E
     */
    public E Delete(String key);

    /**
     * Metodo empty 
     * @return boolean
     */
    public boolean empty();

    /**
     * Metodo count
     * @return int
     */
    public int count();

    /**
     * Metodo Find
     * @param key 
     * @return String[]
     */
    public String[] find(String key);

    /**
     * Metodo InOrder
     * @param nodo
     * @return String
     */
    public String InOrder(Nodo actual);

    /**Metodo PreOrder
     * @param actual Nodo 
     * @return String
     */
    public String PreOrder(Nodo actual);

    /**
     * Metodo PostOrder
     * @param actual 
     * @return String
     */
    public String PostOrder(Nodo actual);


}
