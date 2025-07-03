import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args){
        int[] numbers = new int[1000]; //inisiasi awal array
        for (int i =0; i < 1000; i++){
            numbers[i] = i + 1;
        }
        int[] newNumbers = new int[numbers.length+1]; //array baru setelah penyisipan

        ArrayList<Integer> numbers2 = new ArrayList<>(); //inisiasi Arraylist
        for (int i = 0; i < 1000 ; i++){
            numbers2.add(i+1);
        }
         //Traversal pada Array
        long startTimeTraversal = System.nanoTime();
        System.out.println("Array traversal: " + Arrays.toString((numbers))); //melakukan traversal array
        long stopTimeTraversal = System.nanoTime();
        long durationTraversal = stopTimeTraversal - startTimeTraversal;

        //Traversal pada Arraylist
        long startTimeTraversal2 = System.nanoTime();
        System.out.println("Arraylist traversal: " + numbers2 + "\n"); //melakukan traversal pada rraylist
        long stopTimeTraversal2 = System.nanoTime();
        long durationTraversal2 = stopTimeTraversal2 - startTimeTraversal2;

        //Pencarian pada array
        long startTime = System.nanoTime(); //mencatat waktu sebelum operasi pencarian array dimulai

        int target = 500;
        boolean found = false;
        for (int i = 0; i < numbers.length ; i++ )
            if(numbers[i] == target){
                System.out.println("Pencarian " + target + " dalam array: ditemukan di indeks " + i);
                found = true;
                break;
            }

        long stopTime = System.nanoTime(); //mencatat waktu selesai pencarian pada array
        long durationPencarian = stopTime - startTime; //menghitung waktu operasi dengan mengurangkan waktu stop dengan selesai

        if(!found){
            System.out.println("Tidak ditemukan!");
        }


        //Pencarian pada Arraylist
        long startTime2 = System.nanoTime(); //mencatat waktu mulai operasi pencarian array list

        int target2 = 500;
        int index2 = numbers2.indexOf(target2); //sudah ada built in functionnya

        System.out.println(("Pencarian " + target2 + " dalam arraylist: ditemukan di indeks " + index2 + "\n"));

        long stopTime2 = System.nanoTime(); // waktu selesai operasi pencarian arrayList
        long durationPencarian2 = stopTime2 - startTime2; //Menghitung waktu operasi pencarian arraylist


        // Insertion pada Array
        long startTimeInsertion = System.nanoTime();
        int insertion = 1001;
        int pos = 1000;
        System.arraycopy(numbers, 0, newNumbers, 0, pos); //menggunakan arraycopy untuk menyalin bilangan sebelum pos newNumbers
        newNumbers[pos] = insertion; //menyisipkan bilangan ke newNumbers
        System.arraycopy(numbers,pos, newNumbers,pos+1,numbers.length - pos); //menggunakan arraycopy

        System.out.println("Array setelah penyisipan: " + Arrays.toString((newNumbers)));
        long stopTimeInsertion = System.nanoTime();
        long durationInsertion = stopTimeInsertion - startTimeInsertion;


        //Insertion pada Arraylist
        long startTimeInsertion2 = System.nanoTime();
        numbers2.add(1000,1001); //sudah ada builtin fuction untuk operasi penyisipan pada arraylist
        System.out.println("Arraylist setelah penyisipan: " + numbers2 + "\n");
        long stopTimeInsertion2 = System.nanoTime();
        long durationInsertion2 = stopTimeInsertion2 - startTimeInsertion2;


        //Delete pada Array
        long startTimeDeletion = System.nanoTime();
        int[] deleteNumbers = new int[newNumbers.length-1];
        int indexDeletion = 0;
        System.arraycopy(newNumbers, 0, deleteNumbers, 0, indexDeletion );
        System.arraycopy(newNumbers, indexDeletion + 1, deleteNumbers, indexDeletion, newNumbers.length-1-indexDeletion);
        System.out.println("Array setelah penghapusan: " + Arrays.toString((deleteNumbers)));
        long stopTimeDeletion = System.nanoTime();
        long durationDeletion = stopTimeDeletion - startTimeDeletion;


        // Delete pada arraylist
        long startTimeDeletion2 = System.nanoTime();
        numbers2.remove(0);
        System.out.println("Arraylist setelah penghpausan: " + numbers2 + "\n");
        long stopTimeDeletion2 = System.nanoTime();
        long durationDeletion2 = stopTimeDeletion2 - startTimeDeletion2;


        //Reverse pada Array
        int[] reverseNumbers = new int[deleteNumbers.length];
        for(int i = 0 ; i < deleteNumbers.length; i++){
            reverseNumbers[i] = deleteNumbers[deleteNumbers.length - 1 - i];
        }
        long startTimeReverse = System.nanoTime();
        System.out.println("Array Reverse: " + Arrays.toString((reverseNumbers)));
        long stopTimeReverse = System.nanoTime();
        long durationReverse = stopTimeReverse - startTimeReverse;


        //Reverse pada arraylist
        long startTimeReverse2 = System.nanoTime();
        Collections.reverse(numbers2);
        System.out.println("Arraylist Reverse: " + numbers2 +"\n");
        long stopTimeReverse2 = System.nanoTime();
        long durationReverse2 = stopTimeReverse2 - startTimeReverse2;



        System.out.println("Waktu eksekusi traversal pada Array: " + ((float) durationTraversal/1e6 + " ms"));
        System.out.println("Waktu eksekusi pencarian pada Array: " + ((float) durationPencarian/1e6 + " ms"));
        System.out.println("Waktu eksekusi insertion pada Array: " + ((float) durationInsertion/1e6 + " ms"));
        System.out.println("Waktu eksekusi deletion pada Array: " + ((float) durationDeletion/1e6 + " ms"));
        System.out.println("Waktu eksekusi reversal pada Array: " + ((float) durationReverse/1e6 + " ms\n"));


        System.out.println("Waktu eksekusi traversal pada Arraylist: " + ((float) durationTraversal2/1e6 + " ms"));
        System.out.println("Waktu eksekusi pencarian pada Arraylist: " + ((float) durationPencarian2/1e6 + " ms"));
        System.out.println("Waktu eksekusi insertion pada Arraylist: " + ((float) durationInsertion2/1e6 + " ms"));
        System.out.println("Waktu eksekusi deletion pada Arraylist: " + ((float) durationDeletion2/1e6 + " ms"));
        System.out.println("Waktu eksekusi reversal pada Arraylist: " + ((float) durationReverse2/1e6 + " ms\n"));

    }
}