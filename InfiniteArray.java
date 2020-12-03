public class InfiniteArray {

    double[] nums;
    int valsStored;
    int n;

    public InfiniteArray(){

        //sets the limit of how many pieces of data there can be in the initial array
        n = 100;

        //creates the array with length n and starts with 0 values stored
        nums = new double[n];
        valsStored = 0;

    }


    public void add(double value){

        //only adds values that are positive
        if (value < 0){
            return;
        }

        //sets the new item to the specific index and adds one to num of values
        nums[valsStored] = value;
        valsStored++;

        //if the number of variables stored is equal to the max it doubles the max
        if (valsStored == n){
            n *= 2;

            //creates temp array
            double[] temp = new double[n];

            //loops through old array and adds it to the new array
            for (int i = 0; i < valsStored; i++){
                    temp[i] = nums[i];
            }

            //the old array becomes the updated one
            nums = temp;
        }
    }


    public double getValue(int index){
        return nums[index];
    }

    //used during testing for the arrays
    public void print(){
        for (int i = 0; i< valsStored; i++){
            System.out.println(nums[i]);
        }

    }

    public void calcStd(){
        //sets starting variables at 0
        int sum = 0;
        double std = 0;

        //loops through the array and adds each num to sum
        for (int i = 0; i < valsStored; i++){
            sum += nums[i];
        }

        //finds mean
        double mean = sum / valsStored;

        //subtracts each number from the mean and squares it
        for (int i = 0; i < valsStored; i++){
            std += Math.pow(nums[i]-mean, 2);
        }

        //takes that final number and finds its square root and prints
        std = Math.pow(std/valsStored, .5);

        System.out.println("The Standard Deviation is " + std);
    }

    //selection sort for the array
    public void sort(){

        for(int i = 0; i < valsStored -1; i++){
            double min = Double.MIN_VALUE;

            for(int j = i+1; j < valsStored; j++){
                min = j;
            }

            double temp = nums[(int)min];
            nums[(int)min] = nums[i];
            nums[i] = temp;

        }

    }
        //finds the middle most number and prints
    public void calcMedian(){
        System.out.println("The median of the array is " +nums[valsStored/2]);
    }
}
