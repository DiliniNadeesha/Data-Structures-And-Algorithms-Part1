class DynamicArray {
    int[] dataArray = new int[0];

    public void add(int data) {
        int[] tempArray = new int[dataArray.length + 1];
        tempArray[tempArray.length - 1] = data;
        for (int i = 0; i < dataArray.length; i++) {
            tempArray[i] = dataArray[i];
        }
        dataArray = tempArray;
    }

    public void printArray() {
        System.out.print("[");
        for (int i = 0; i < dataArray.length; i++) {
            System.out.print(dataArray[i] + ", ");
            if (i == dataArray.length - 1) {
                System.out.print("\b\b");
            }
        }
        System.out.println("]");
    }

    int size() {
        return dataArray.length;
    }

    int get(int index) {
        return dataArray[index];
    }

    public void remove(int index) {
        int[] tempArray = new int[dataArray.length - 1];

        int j = 0;
        for (int i = 0; i < dataArray.length; i++) {
            if (i == index) {
                continue;
            }
            tempArray[j] = dataArray[i];
            j++;
        }
        dataArray = tempArray;
    }

    public void clear() {
        dataArray = new int[0];
    }

    public void set(int index, int data) {
        dataArray[index] = data;
    }

    public boolean isEmpty() {
        return dataArray.length == 0;
    }

    public boolean contains(int data) {
        for (int i : dataArray) {
            if (i == data) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int data) {
        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public void add(int index, int data) {
        int[] tempArray = new int[dataArray.length + 1];
        for (int i = 0; i < tempArray.length; i++) {
            if (i < index){
                tempArray[i] = dataArray[i];
            }else if (i==index){
                tempArray[i] = data;
            }else{
                tempArray[i] = dataArray[i-1];
            }
        }
        dataArray = tempArray;
    }

    public void add(int[] array){
        for (int i : array) {
            add(i);
        }
    }

    public void removeRange(int from, int to) {
        for (int i = 0; i < (to-from) ; i++) {
            remove(from);
        }
    }

    public DynamicArray subArray(int from, int to){
        DynamicArray myda = new DynamicArray();
        for (int i = from; i < to; i++) {
            myda.add(dataArray[i]);
        }
        return myda;
    }
}


public class Demo {

    public static void main(String[] args) {

        DynamicArray da = new DynamicArray();
        da.printArray();    // []

        da.add(100);
        da.add(200);
        da.add(300);
        da.add(400);
        da.printArray();    // [100,200,300,400]
        System.out.println("Size : " + da.size());  // 4

        System.out.println(da.get(1));  // 200

        da.remove(2);
        da.printArray();    // [100,200,400];
        System.out.println("Size : " + da.size());  // 3

        da.clear();
        da.printArray();    // [];
        System.out.println(da.size());  // 0

        //---------------------- 2 Phase ---------------------

        da.add(100);
        da.add(200);
        da.add(300);
        da.add(400);
        da.add(500);

        da.set(2, 350);
        da.printArray();    // [100,200,350,400,50]
        System.out.println("Is Empty : " + da.isEmpty());   // false
        System.out.println("Contains 500 : " + da.contains(500));   // true
        System.out.println("Index of 200 : " + da.indexOf(200));    // 1
        da.clear();

        //---------------------- Final Phase ---------------------

        da.add(100);
        da.add(200);
        da.add(300);
        da.add(400);
        da.add(500);

        da.add(2, 250);
        da.printArray();    // [100,200,250,300,400,500];
        da.add(new int[]{600,700,800});
        da.printArray();    // [100,200,250,300,400,500,600,700,800]
        da.removeRange(1,3);
        da.printArray();    // [100,300,400,500,600,700,800]
        DynamicArray subArray = da.subArray(1,4);
        subArray.printArray();  // [300,400,500]

    }

}
