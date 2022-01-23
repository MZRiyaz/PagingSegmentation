package pagingsegmentation;

/*
 * @author Muhammad Zakria Riyaz
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class PagingSegmentation {

  
    public static void main(String[] args) {
       //Creating a random function 
         Random rand= new Random();
         
       //Greeting to the program 
        System.out.println("Welcome to the First Fit Memory Manager program");
        System.out.println("");
        
       //Creating Scanner for inputs
       Scanner inputter= new Scanner(System.in);
       
       //Asking user for total memory in this manager
        System.out.println("Please enter the total memory in KB of this memory manager");
        int TotalMemory= inputter.nextInt();
        
      //Asking user for operating system memory
        System.out.println("");
        System.out.println("Please enter the the total memory in KB that the operating system will hold");
        int OSMemory= inputter.nextInt();
      
      //Asking user how many processes will be within the memory manager
        System.out.println("");
        System.out.println("Please enter the number of processes this memory manager will need to hold");
        int TotalProcesses= inputter.nextInt();
        
      //Creating memory manager array equal to that 
        int[] MemoryManagerArray=new int[TotalProcesses+1];
      
      //Setting the OS memory to have its own block within this array
        MemoryManagerArray[0]= OSMemory;
        int LeftOver;
        LeftOver=(TotalMemory-OSMemory);
       
      //Informing user of the space currently left in the manager
        System.out.println("");
        System.out.println(Arrays.toString(MemoryManagerArray));
        System.out.println("With the input of the OS memory, which will be Process 0, the memory manager now has " + LeftOver + "KB of memory left" );
        System.out.println("");
        
            
          
      
        
       //Getting all the inputs for the array 
       for(int x=1; x<=TotalProcesses;){
        
       //Asking user to select what they want to do within the memory manager
       System.out.println("Hit 1 for Compaction of the manager. Hit 2 for Addition of processes. Hit 3 for Deletion of processes. Hit 4 to Terminate program");
       //Variable Menu will keep track of what option the user chose
       int Menu=inputter.nextInt();
       System.out.println("");
           
      
       //If user chose additon of processes, this code will execute
      if (Menu==2) {
        
        //Asking user if they want to randomize the process size of the current process
       System.out.println("Do you want to randomize the size of Process " + x +" Hit 1 for yes or any other digit for no");
       double Random= inputter.nextDouble();
       
       //If user slects 1 for randomizing, this code will execute
       if (Random==1){
       //The random  num will be less than the LeftOver variable which is equal tot he amount of remaining memory
        int RandomNum= rand.nextInt(LeftOver);
        //This RandomNum is now inputted into the array
        MemoryManagerArray[x]=RandomNum;
        //Leftover variable keeps track of remaining memory  by subtracting the current process size from the current value of LeftOver
        LeftOver=LeftOver-(RandomNum++);
        //Printing out array to show what blocks are left within memory manager
        System.out.println(Arrays.toString(MemoryManagerArray));
        System.out.println("The Memory Manager now has "+ LeftOver + "KB of memory left");
        
        //******************* ARRAY WILL ONLY MOVE ONTO NEXT PROCESS NUMBER IF A PROCESS IS ADDED, THUS X++ ISN'T A PAREMETER IN THE FOR LOOP, BUT DOWN HERE************
        x++;
       }
       
       
       //If user doesn't want randomized process size, this code will execute 
       else if (Random!=1){
       //User inputs the size of their process under variable ProcessInput
        System.out.println("Enter the size of Process " + x);
       int ProcessInput= inputter.nextInt();
       
       //If process size inputted is larger than the total memory size or remeainign memory, user is asked to input another size until its within range
        while (ProcessInput >= TotalMemory || ProcessInput >= LeftOver){
            System.out.println("The size of this process is either larger than the total memory or larger than remaining space, please try another value less than" + LeftOver +"KB");
            System.out.println("");
            ProcessInput= inputter.nextInt();
            System.out.println(Arrays.toString(MemoryManagerArray));
        }
       //Once user enters a process size within range, 
       System.out.println("");
       if (ProcessInput < TotalMemory && ProcessInput<LeftOver){
       MemoryManagerArray[x]= ProcessInput;
       int Processes=ProcessInput++;
       LeftOver=(LeftOver)-(Processes++);
       System.out.println(Arrays.toString(MemoryManagerArray));
       System.out.println("The Memory Manager now has "+ LeftOver + "KB of memory left");
       x++;
       }
       }
      }
       
     //If user wants to extract a process and delete from memory manager, this code will execute
      System.out.println("");
      if (Menu==3){
        System.out.println("What process # would you like to remove from array");
        System.out.println("");
        //Whatever process number the user wants to delete will be set to zero
        int Remover= inputter.nextInt();
        //Adding the extracted process size back to the LeftOver variable because more memory just opened up after deletion
        LeftOver=(LeftOver)+MemoryManagerArray[Remover];
        MemoryManagerArray[Remover]=0;
        System.out.println(Arrays.toString(MemoryManagerArray));
       
    }   



     //If user selects to compact array, this code will execute  
    if (Menu==1){
    int Tracker = 0;
    //Code checks to see if there are any blocks in the array equal to 0 and if there are, every block after that is brought back 1 block so that the array fills up with no 0's in between
    for (int j = 0; j < MemoryManagerArray.length; j++) {
        if (MemoryManagerArray[j] != 0) {
            MemoryManagerArray[Tracker++] = MemoryManagerArray[j];
        }
    }
    while (Tracker < MemoryManagerArray.length) {
        MemoryManagerArray[Tracker++] = 0;
    }
        System.out.println(Arrays.toString(MemoryManagerArray));
       
    }
    
    // If user selects to terminate program, this code will execute 
    if (Menu==4){
        System.out.println("Program Terminated");
    // Since program is in a loop, the only to exit would be to surpass the parameters of the original for loop which is what the code below does
        x=TotalProcesses+1;
        
    }
       }
    }
}


    

     

