import java.util.Scanner;

public class Huffmann {

    public static Node[] parray;
    static int n = 0;
    public static Node root = null;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Huffmann's Tree Formation");
        System.out.println();
        System.out.println("Enter Number of weights to be put");
        n =  sc.nextInt();
        int[] w = new int[n];
        parray = new Node[n];
        System.out.println("Enter the Weights");
        int i;

        //Weighted Array
        for(i = 0;i < n;i++){
            w[i] = sc.nextInt();
        }

        //Node's Array
        for (i = 0;i < n;i++){
            parray[i]  = new Node(w[i],null,null);
        }

        //Creating Huffmann's Tree
        Node ptr = null;
        for (i = 0;i < n - 1;i++){
            sortArray(parray);
            ptr = new Node(0,null,null);
            ptr.left = parray[i];
            ptr.right = parray[i + 1];
            ptr.weight = ptr.left.weight + ptr.right.weight;
            parray[i + 1] = ptr;
        }
        root = parray[n - 1];

        //Traversing Huffmann's Tree
        inorder(root);
    }

    private static void sortArray(Node[] parray) {
        int l = parray.length;
        Node temp;
        int j,k;
        for (j = 0;j < l - 1;j++){
            k = 0;
            while(k < (l - j) - 1){
                if(parray[k].weight > parray[k + 1].weight) {
                    temp = parray[k];
                    parray[k] = parray[k + 1];
                    parray[k + 1] = temp;
                }
                k++;
            }
        }
    }

    private static void inorder(Node r){
        if (r == null){
            return;
        }else{
            inorder(r.left);
            System.out.print(r.weight + " | ");
            inorder(r.right);
        }
    }
}
