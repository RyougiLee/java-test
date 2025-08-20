import java.util.Scanner;

class Assignment_1{
    public static void main(String[] args) {
        String[] firstnames = {"James","Michael","John","Robert","David","William"};
        String[] lastnames = {"Elsher","Solace","Levine","Thatcher","Raven","Bardot"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of names:");
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            int randomNum1 = (int) (Math.random() * 6);
            int randomNum2 = (int) (Math.random() * 6);
            System.out.println(firstnames[randomNum1]+" "+lastnames[randomNum2]);
        }
    }
}

class Assignment_2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the integers into the array:");
        for(int i=0;i<n;i++){
            System.out.println("Enter integer "+ (i+1) +" :" );
            nums[i] = sc.nextInt();
        }
        int sum=0;
        int[][] subarray = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                sum+=nums[j];
                subarray[i][j]=sum;
            }
            sum=0;
        }

        int max=0,maxA=0,maxB=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(subarray[i][j]>max){
                    max=subarray[i][j];
                    maxA=i+1;
                    maxB=j+1;
                }
            }
        }
        System.out.println("The maximum number is "+max);
        System.out.println("Integers "+maxA+"-"+maxB);

    }
}

class Assignment_3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        boolean duplicate=false;
        int count=0;
        System.out.println("Enter the integers into the array:");
        for(int i=0;i<n;i++){
            System.out.println("Enter integer "+ (i+1) +" :" );
            int num = sc.nextInt();
            for(int j=0;j<i;j++){
                if(nums[j]==num){
                    duplicate=true;
                }
            }
            if(!duplicate){
                nums[count]=num;
                count++;
            }
            duplicate=false;
        }
        for(int i=0;i<count;i++){
            System.out.print(nums[i]+" ");
        }
    }
}