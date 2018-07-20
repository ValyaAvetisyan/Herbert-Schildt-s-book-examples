package old.stack;

public class StackImpl <E> implements Stack<E> {
    public static final int DEFAULT_CAPACITY = 16;

    private Object[] content;
    private int tos;

    public StackImpl() {
       this(DEFAULT_CAPACITY);
    }

    public StackImpl(int capacity) {
        content = new Object[capacity];
        tos = -1;
    }

    /**
     * Gets the last pushed element into the stack
     * and decrements the tos value.
     * @return element of stack last pushed in to 'content'
     */
    public E pop (){
        if(tos == -1){
            return null;
        }
        return (E)content[tos--];
    }

    /**
     * pushes the specified 'value' into the 'content' bookArray
     * and increments the tos value.
     * @param value
     */
    public void push(E value){
       if(tos == content.length-1){
           extendContent();
       }
       content[++tos] = value;
    }

    /**
     * This method creates a new bookArray with length greater then content length
     * and then fills the elements of content into the new created bookArray.
     * after that the reference of the new bookArray must be assigned to the content
     */
    private void extendContent(){
        Object[] newContent = new Object [content.length *3/2];
        System.arraycopy(content, 0, newContent, 0, content.length);
        content = newContent;
    }

    /**
     * Clears the content of 'content' bookArray by setting the tos value -1.
     */
    public void reset(){
        tos = -1;

    }

    public boolean isEmpty(){
        return tos == -1;
    }
   
    
}
