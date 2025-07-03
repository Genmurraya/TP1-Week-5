import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan jumlah elemen:");
        int elemen = scanner.nextInt();

        int[] numbers = new int[elemen]; //inisiasi awal array
        for (int i = 0; i < elemen; i++) {
            numbers[i] = i + 1;
        }
        ArrayList<Integer> numbers2 = new ArrayList<>(); //inisiasi Arraylist
        for (int i = 0; i < elemen; i++) {
            numbers2.add(i + 1);
        }

        Operation operator = new Operation();
        Comparison comparer = new Comparison();

        System.out.println("Performa Operasi dasar Array\n");
        long[] arrayDurations = operator.ArrayOperation(numbers);

        System.out.println("Performa Operasi dasar pada Arraylist\n ");
        long [] arraylistDuration = operator.ArraylistOperation(numbers2);

        System.out.println("Perbandingan Kedua Operasi\n ");
        comparer.printComparisonResult(arrayDurations, arraylistDuration);

    }
}
class Operation{

        private void printOperationTime(String operation, long duration){
            System.out.println("Waktu Eksekusi " + operation + ": " + ((float) duration / 1e6 + " ms\n" ));
        }

        public long[] ArrayOperation(int[] numbers) {
            long[] durations = new long[5];

            //Traversal pada Array
            long startTimeTraversal = System.nanoTime();
            System.out.println("Array traversal: " + Arrays.toString((numbers))); //melakukan traversal array
            long stopTimeTraversal = System.nanoTime();
            durations[0] = stopTimeTraversal - startTimeTraversal;
            printOperationTime("Traversal pada array: ", durations[0]);

            //Pencarian pada array
            long startTime = System.nanoTime(); //mencatat waktu sebelum operasi pencarian array dimulai
            int target = numbers.length/2;
            boolean found = false;
            for (int i = 0; i < numbers.length; i++)
                if (numbers[i] == target) {
                    System.out.println("Pencarian " + target + " dalam array: ditemukan di indeks " + i);
                    found = true;
                    break;
                }
            if (!found) {
                System.out.println("Tidak ditemukan!");
            }
            long stopTime = System.nanoTime(); //mencatat waktu selesai pencarian pada array
            durations[1] = stopTime - startTime; //menghitung waktu operasi dengan mengurangkan waktu stop dengan selesai
            printOperationTime("Searching pada array: ", durations[1]);


            // Insertion pada Array
            long startTimeInsertion = System.nanoTime(); //mencatat waktu mulai operasi
            int [] newNumbers = new int [numbers.length+1];
            int insertion = numbers.length+ 1;
            int pos = numbers.length;
            System.arraycopy(numbers, 0, newNumbers, 0, pos); //menggunakan arraycopy untuk menyalin bilangan sebelum pos newNumbers
            newNumbers[pos] = insertion; //menyisipkan bilangan ke newNumbers
            System.arraycopy(numbers, pos, newNumbers, pos + 1, numbers.length - pos); //menggunakan arraycopy untuk menyalin bilangan setelah bilangan baru

            System.out.println("Array setelah penyisipan: " + Arrays.toString((newNumbers)));
            long stopTimeInsertion = System.nanoTime(); //mencatat waktu selesia operasi
            durations[2] = stopTimeInsertion - startTimeInsertion; //menghitung waktu operasi
            printOperationTime("Penyisipan pada array: ", durations[2]);


            //Delete pada Array
            long startTimeDeletion = System.nanoTime(); //mencatat waktu awal sebelum mulai
            int[] deleteNumbers = new int[newNumbers.length - 1]; // total elemen array yang dihapus -1 dari array sebelumnya
            int indexDeletion = 0;
            System.arraycopy(newNumbers, 0, deleteNumbers, 0, indexDeletion); //mengcopy isi array sebelum yang ingin dihapus
            System.arraycopy(newNumbers, indexDeletion + 1, deleteNumbers, indexDeletion, newNumbers.length - 1 - indexDeletion); //mengcopy isi array setelah ingin dihapus
            System.out.println("Array setelah penghapusan: " + Arrays.toString((deleteNumbers)));
            long stopTimeDeletion = System.nanoTime(); //mencatat waktu saat selesai
            durations[3] = stopTimeDeletion - startTimeDeletion; // menghitung lamanya operasi
            printOperationTime("Delete pada array: ", durations[3]);

            //Reverse pada Array
            long startTimeReverse = System.nanoTime(); //mencatat waktu mulai
            int[] reverseNumbers = new int[deleteNumbers.length]; //membuat array baru
            for (int i = 0; i < deleteNumbers.length; i++) {
                reverseNumbers[i] = deleteNumbers[deleteNumbers.length - 1 - i]; //array baru nilainya dari kecil ke besar diisi dengna nilai array lama dari besar ke kecil
            }
            System.out.println("Array Reverse: " + Arrays.toString((reverseNumbers)));
            long stopTimeReverse = System.nanoTime(); //mencatat waktu selesai
            durations[4] = stopTimeReverse - startTimeReverse; //mencatat waktu
            printOperationTime("Reverse pada array: ",durations[4]);

            return durations;

        }



        public long[] ArraylistOperation(ArrayList<Integer> numbers2) {
            long[] durations = new long[5];

            //Traversal pada Arraylist
            long startTimeTraversal2 = System.nanoTime();
            System.out.println("Arraylist traversal: " + numbers2); //melakukan traversal pada rraylist
            long stopTimeTraversal2 = System.nanoTime();
            durations[0] = stopTimeTraversal2 - startTimeTraversal2;
            printOperationTime("Tranversal pada arraylist: ",durations[0]);


            //Pencarian pada Arraylist
            long startTime2 = System.nanoTime(); //mencatat waktu mulai operasi pencarian array list
            int target2 = numbers2.size();
            int index2 = numbers2.indexOf(target2); //sudah ada built in functionnya
            System.out.println(("Pencarian " + target2 + " dalam arraylist: ditemukan di indeks " + index2));

            long stopTime2 = System.nanoTime(); // waktu selesai operasi pencarian arrayList
            durations[1]= stopTime2 - startTime2; //Menghitung waktu operasi pencarian arraylist
            printOperationTime("Searching pada arraylist: ",durations[1]);

            //Insertion pada Arraylist
            long startTimeInsertion2 = System.nanoTime();
            numbers2.add(numbers2.size(), numbers2.size() + 1); //sudah ada builtin fuction untuk operasi penyisipan pada arraylist
            System.out.println("Arraylist setelah penyisipan: " + numbers2);
            long stopTimeInsertion2 = System.nanoTime();
            durations[2] = stopTimeInsertion2 - startTimeInsertion2;
            printOperationTime("Inserton pada arraylist: ",durations[2]);

            // Delete pada arraylist
            long startTimeDeletion2 = System.nanoTime();
            numbers2.remove(0); //menghapus index yang diinginkan
            System.out.println("Arraylist setelah penghpausan: " + numbers2);
            long stopTimeDeletion2 = System.nanoTime();
            durations[3] = stopTimeDeletion2 - startTimeDeletion2;
            printOperationTime("delete pada arraylist: ",durations[3]);


            //Reverse pada arraylist
            long startTimeReverse2 = System.nanoTime();
            Collections.reverse(numbers2); //melakukan reversal
            System.out.println("Arraylist Reverse: " + numbers2);
            long stopTimeReverse2 = System.nanoTime();
            durations[4] = stopTimeReverse2 - startTimeReverse2;
            printOperationTime("Reverse pada arraylist: ",durations[4]);

            return durations;
        }
}

class Comparison{
    public void printComparisonResult(long[] arrayDurations, long[] arraylistDurations) {
        System.out.println("Waktu eksekusi traversal pada Array: " + ((float) arrayDurations[0] / 1e6 + " ms"));
        System.out.println("Waktu eksekusi pencarian pada Array: " + ((float) arrayDurations[1] / 1e6 + " ms"));
        System.out.println("Waktu eksekusi insertion pada Array: " + ((float) arrayDurations[2] / 1e6 + " ms"));
        System.out.println("Waktu eksekusi deletion pada Array: " + ((float) arrayDurations[3] / 1e6 + " ms"));
        System.out.println("Waktu eksekusi reversal pada Array: " + ((float) arrayDurations[4] / 1e6 + " ms\n"));

        System.out.println("Waktu eksekusi traversal pada Arraylist: " + ((float) arraylistDurations[0] / 1e6 + " ms"));
        System.out.println("Waktu eksekusi pencarian pada Arraylist: " + ((float) arraylistDurations[1] / 1e6 + " ms"));
        System.out.println("Waktu eksekusi insertion pada Arraylist: " + ((float) arraylistDurations[2] / 1e6 + " ms"));
        System.out.println("Waktu eksekusi deletion pada Arraylist: " + ((float) arraylistDurations[3] / 1e6 + " ms"));
        System.out.println("Waktu eksekusi reversal pada Arraylist: " + ((float) arraylistDurations[4] / 1e6 + " ms\n"));
    }
}
