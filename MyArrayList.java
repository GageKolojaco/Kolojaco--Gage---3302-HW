public class MyArrayList extends ADTList<String> {

    private String[] firstArray;
    private int size;
    public int INITIAL_SIZE = 2;

    public MyArrayList() {

        this.firstArray = new String[INITIAL_SIZE];
        this.size = 0;

    }

    @Override
    public boolean isEmpty() { // returns if the list is empty

        return (this.size == 0);

    }

    @Override
    public int size() { // returns the size of the list

        return this.size;

    }

    @Override
    public void add(String item) {

        if (this.size() == this.firstArray.length){
            String tempArray[] = new String[firstArray.length * 2];
            for (int i = 0; i < firstArray.length; i++){
                tempArray[i] = firstArray[i];
            }
            tempArray[size] = item;
            size++;
          firstArray = tempArray;
        }

        else{
        //    tempArray[size] = item;
            size++;
        }

    }


    @Override
    public String remove(int index) {

        String returnVal = null;

        if (index < 0 || index >= this.size()){

            throw new MyArrayListException("Index" + index +" is invalid for a list of " + size + " size.");

        }

        if ((this.size - 1) / this.firstArray.length <= 0.25){ // if we need to shrink the array

            if (index > 0 || index <= this.size()){ // checking for valid index

                returnVal = firstArray[index];
                for (int i = index + 1; i < this.size(); i++){
                    this.firstArray[i-1] = this.firstArray[i];
                }

                String tempArray[] = new String[firstArray.length / 2];
                for (int i = 0; i < this.size; i++){
                        tempArray[i] = firstArray[i];
        
                } 
                firstArray = tempArray;
                    size--;

            }//if vALID

        }//end of shrinking
        

        else {

            if (index > 0 || index <= this.size()){ // checking for valid index

                returnVal = firstArray[index];
                for (int i = index + 1; i < this.size(); i++){
                    this.firstArray[i-1] = this.firstArray[i];// invalid index

                }
                
           
            
            size--;
            
        }

        this.size--;
        return returnVal;

    }

    @Override
    public void remove(String item) {

        int stop = 0;

         for (int i = 0; i < this.size && stop == 0; i++){

            if (firstArray[i] == item){
                remove(i);
                stop++;
            }
        
         }

    }

    @Override
    public String get(int index) { // gets an element at a given index

        if (index < 0 || index >= this.size()){
            throw new MyArrayListException("Index" + index +" is invalid for a list of " + size + " size.");
        }

        return this.firstArray[index];

    }

    @Override
    public void removeAll() { // resets "size" to 2 and generates a new list

        this.size = 2;
        this.firstArray = new String[INITIAL_SIZE];

    }

   
    
}
