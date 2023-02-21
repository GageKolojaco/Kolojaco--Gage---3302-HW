public class MyArrayList extends ADTList<String> {

    private String[] firstArray;
    private int size;
    public int INITIAL_SIZE = 2;

    public MyArrayList() {

        this.firstArray = new String[INITIAL_SIZE];
        this.size = 0;

    } // end of constructor

    @Override
    public boolean isEmpty() { // returns if the list is empty

        return (this.size == 0);

    } // end of isEmpty()

    @Override
    public int size() { // returns the size of the list

        return this.size;

    } // end of size()

    @Override
    public void add(String item) {

        String tempArray[];

        if (this.size() == this.firstArray.length){
            tempArray = new String[firstArray.length * 2];
            for (int i = 0; i < firstArray.length; i++){
                tempArray[i] = firstArray[i];
            }
            tempArray[size] = item;
            size++;
          firstArray = tempArray;
        }

        else{

            firstArray[size] = item;
            size++;
        }

    } // end of add()


    @Override
    public String remove(int index) {

        String returnItem = null; // local variable used to return previous value

        if (index < 0 || index >= this.size()){ // exception handling

            throw new MyArrayListException("Index" + index +" is invalid for a list of " + size + " size.");

        }

        if ((this.size - 1) / this.firstArray.length <= 0.25){ // if we need to shrink the array

            if (index > 0 || index <= this.size()){ // checking for valid index

                returnItem = firstArray[index];
                for (int i = index + 1; i < this.size(); i++){
                    this.firstArray[i-1] = this.firstArray[i];
                }

                String tempArray[] = new String[firstArray.length / 2];
                for (int i = 0; i < this.size; i++){
                        tempArray[i] = firstArray[i];
        
                } 
                firstArray = tempArray;
                    size--;

            } // end of checking for validity

        } //end of shrinking
        

        else { // if we DON'T have to shrink

            if (index > 0 || index <= this.size()){ // checking for valid index

                returnItem = firstArray[index];
                for (int i = index + 1; i < this.size(); i++){
                    this.firstArray[i-1] = this.firstArray[i];

                }

            } // end of checking for validity
            
            this.size--;
            
        }

        this.size--;
        return returnItem;

    } // end of remove(int)

    @Override
    public void remove(String item) {

        int stop = 0;

         for (int i = 0; i < this.size && stop == 0; i++){

            if (firstArray[i] == item){ // if given item matches item in list
                remove(i);
                stop++;
            } // end of matching
        
         } // end of loop

    } // end of remove(String)

    @Override
    public String get(int index) { // gets an element at a given index

        if (index < 0 || index >= this.size()){ // exception handling

            throw new MyArrayListException("Index" + index +" is invalid for a list of " + size + " size.");

        }

        return this.firstArray[index]; // return the element

    } // end of get()

    @Override
    public void removeAll() { // resets "size" to 2 and generates a new list

        this.size = 2;
        this.firstArray = new String[INITIAL_SIZE];

    } // end of removeAll()

}
