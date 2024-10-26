package Arrays;
public class BubbleShort {
public static void main(String[] args) {
    
    int array[]={9,5,2,4,8,2,9};
    for(int i=0;i<array.length;i++){
        for(int j=1;j<array.length-i;j++){
            if (array[j]<array[j-1]) { // 5<9
                int temp=array[j]; //5
                array[j]=array[j-1]; // j=1 -- 9
                array[j-1]=temp; // 5

                 

                
            }  

        }
        
    }
    for(int i=0;i<array.length;i++){
        System.out.print(array[i]+" ");
    }
    
}    

}
