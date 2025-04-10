import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class loadingSystem{
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		
		LocalDateTime Date=LocalDateTime.now().plusHours(8);
		
		DateTimeFormatter format=DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm a");
		
		String Dt=Date.format(format);
		
		String[] Gprefixes={"0817","0904","0905","0906","0915","0916","0917","0926","0927","0935","0936","0937","0945","0953","0954","0955","0956","0965","0966","0967","0975","0977","0978","0979","0980","0994","0995","0996","0997"};
		
		String[] Sprefixes={"0813","0907","0908","0909","0910","0911","0912","0913","0914","0918","0919","0920","0921","0928","0929","0930","0938","0939","0940","0946","0947","0948","0949","0950","0951","0961","0963","0968","0969","0970","0981","0989","0992","0998","0999" };
		
		
		String[] Dprefixes={"0895","0896","0897","0898","0991", "0992", "0993","0994"};
		
		int ON=1000123;
		int balance=0;
		String number="";
		int loadt=0;
		String promo="";
		String T="";
		int price=0;
		int amount=0;
		
		while(true){
			System.out.println("***************************************");
			System.out.println("Welcome to Group 8 Loading System");
			System.out.println("Bl: "+balance);
			System.out.println("What Do You Want To Buy");
			System.out.println("1. Buy Balance");
			System.out.println("2. Buy Load");
			System.out.println("3. Exit");
			if(!scanner.hasNextInt()){
			System.out.println("Invalid Input, Enter a Number from 1-3, Try Again");
			scanner.next();
			continue;
		}
		int buy=scanner.nextInt();
		System.out.println("***************************************");
		if(buy==1){
			while(true){
				System.out.println("Enter 0 to Cancel");
				System.out.println("Enter The Amount of Balance You Want to Buy");
				if(!scanner.hasNextInt()){
					System.out.println("Invalid Input, Enter a Whole Number, Try Again");
					System.out.println("*********************************************************");
					scanner.next();
					continue;
				}									
				amount=scanner.nextInt();
				System.out.println("***************************************");
				if(amount==0){
					amount=0;
					price=0;
					break;
				}
				else if(amount>0){
					balance+=amount;
					System.out.println("Succesfully buyed "+amount+" balance");
					break;						
				}
				else{
					System.out.println("Invalid Amount, Try Again");
					continue;				
				}	
			}
		}
		
		else if(buy==2){
				System.out.println("Bl: "+balance);
				System.out.println("Select Telco");
				System.out.println("1. Globe or TM");
				System.out.println("2. Smart or TNT");
				System.out.println("3. Dito");
				System.out.println("4. Back");
				if(!scanner.hasNextInt()){
					System.out.println("Invalid Input, Enter a Number from 1-4, Try Again");
					scanner.next();
					continue;
				}
				int Telco=scanner.nextInt();
				scanner.nextLine();
				System.out.println("***************************************");
				if (Telco<1 || Telco>4){
					System.out.println("Invalid Input, Enter a Number from 1-4, Try Again");
					continue;
				}
				else if(Telco==4){
					continue;
				}
				
				System.out.println("Enter 0 to Cancel");
				System.out.println("Enter The Mobile Number");
				number=scanner.nextLine();
				System.out.println("***************************************");
				
				if(number.length()!=11){
					System.out.println("Invalid Mobile Number, Try Again");
					continue;
				}
				
				String prefix=number.substring(0,4);
				boolean valid =false;
				
				if(Telco==1){
					T="Globe or TM";
					for(int i=0; i<Gprefixes.length; i++){
						if(prefix.equals(Gprefixes[i])){
							valid=true;
						}
					}
					
					if (valid){
						while(true){
							System.out.println("Bl: "+balance);
							System.out.println("Select Load Type");
							System.out.println("1. Regular");
							System.out.println("2. Go+");
							System.out.println("3. Back");
							if(!scanner.hasNextInt()){
								System.out.println("Invalid Input, Enter a Number from 1-3 , Try Again");
								scanner.next();
								continue;
							}
							loadt=scanner.nextInt();
							System.out.println("***************************************");
							if(loadt==1){
								promo="Regular";
								System.out.println("Bl: "+balance);
								System.out.println("Enter 0 to Cancel");
								System.out.println("Enter The Amount of Regular Load You Want to Buy");
								if(!scanner.hasNextInt()){
									System.out.println("Invalid Input, Enter a Whole Number, Try Again");
									scanner.next();
									continue;
								}
								price=scanner.nextInt();
								System.out.println("***************************************");		
								if(price==0){
									continue;
								}
								else if (price<balance){
									balance-=price;
									break;
								}
								else{
									System.out.println("Insufficient Balance, Try Again");
									System.out.println("***************************************");
									continue;
								}
							}
							
							else if(loadt==2){
								promo="Go+";
								System.out.println("Bl: " +balance);
								System.out.println("Select Go+ Promo you want to purchase");
								System.out.println("1. Go+99");
								System.out.println("2. Go+129");
								System.out.println("3. Go+149");
								System.out.println("4. Go+179");
								System.out.println("5. Go+250");
								System.out.println("6. Back");
								if(!scanner.hasNextInt()){System.out.println("Invalid Input, Enter a Number from 1-6, Try Again");
								scanner.next();
								continue;
								}
								int Go=scanner.nextInt();
								System.out.println("***************************************");
								if (Go<1 || Go >6){
									System.out.println("Invalid Input, Enter a Number from 1-6, Try Again");
									System.out.println("***************************************");
									continue;
								}
								else if(Go==6){
									continue;
								}
								
								switch(Go){
									case 1:
									price=99;
									break;
									case 2:
									price=129;
									break;
									case 3:
									price=149;
									break;
									case 4:
									price=179;
									break;
									case 5:
									price=250;
									break;
								}
								
								if (price<balance){
								 balance-=price;
									break;
								}
								else{
									System.out.println("Insufficient balance, try again");
								 System.out.println("*********************************************************");
								 continue;						
								}								         
							}
							else if(loadt==3){
								amount=0;
								price=0;
								break;
							}						
							else {
								System.out.println("Invalid Input, Enter a Number from 1-3 , Try Again");
								continue;
							}							
						}
					}
					else {
								System.out.println("The mobile number is not for this Telco");
								continue;
					}
				}
				
				else if(Telco==2){
					T="Smart or TNT";
					for(int i=0; i<Sprefixes.length; i++){
						if(prefix.equals(Sprefixes[i])){
							valid=true;
						}
					}
					
					if (valid){
						while(true){
							System.out.println("Select Load Type");
							System.out.println("1. Regular");
							System.out.println("2. Giga");
							System.out.println("3. Back");
							if(!scanner.hasNextInt()){
								System.out.println("Invalid Input, Enter a Number from 1-3 , Try Again");
								scanner.next();
								continue;
							}
							loadt=scanner.nextInt();
							System.out.println("*********************************************************");
							if(loadt==1){
								promo="Regular";
								System.out.println("Bl: "+balance);
								System.out.println("Enter 0 to Cancel");
								System.out.println("Enter The Amount of Regular Load You Want to Buy");
								if(!scanner.hasNextInt()){
									System.out.println("Invalid Input, Enter a Whole Number, Try Again");
									scanner.next();
									continue;
								}
								price=scanner.nextInt();
								System.out.println("***************************************");
								if(price==0){
									continue;
								}
								else if (price<balance){
									balance-=price;
									break;
								}
								else{
									System.out.println("Insufficient Balance, Try Again");
									System.out.println("***************************************");
									continue;
								}
							}
							
							else if(loadt==2){
								promo="GigaStories";
								System.out.println("BL: " +balance);
								System.out.println("Select Giga Promo you want to purchase");
								System.out.println("1. GigaStories 50");
								System.out.println("2. GigaStories 99");
								System.out.println("3. GigaStories 299");
								System.out.println("4. GigaStories 399");
								System.out.println("5. GigaStories 499");
								System.out.println("6. Back");
								if (!scanner.hasNextInt()){
									System.out.println("Invalid Input, Enter a Number from 1-6, Try Again");
									scanner.next();
									continue;
								}
								int Giga=scanner.nextInt();
								System.out.println("***************************************");
								if (Giga<1 || Giga>6){
									System.out.println("Invalid Input, Enter a Number from 1-6, Try Again");
									continue;
								}
								else if(Giga==6){
									continue;
								}
								
								switch(Giga){
									case 1:
									price=50;
									break;
									case 2:
									price=99;
									break;
									case 3:
									price=299;
									break;
									case 4:
									price=399;
									break;
									case 5:
									price=499;
									break;							
									}
									
									if (price<balance){
								 balance-=price;
									break;
								}
								else{
									System.out.println("Insufficient balance, try again");
								 System.out.println("*********************************************************");
								 continue;						
								}
							}
							else if(loadt==3){
								amount=0;
								price=0;
								break;
							}						
							else {
								System.out.println("Invalid Input, Enter a Number from 1-3 , Try Again");
								continue;
							}
							}
						}
						else{
								System.out.println("The mobile number is not for this Telco");
								continue;
						}					
				}
				
				else if(Telco==3){
					T="Dito";
					for(int i=0; i<Dprefixes.length;i++){
						if(prefix.equals(Dprefixes[i])){
							valid=true;
						}
					}
					
					if(valid){
						while(true){
							System.out.println("Select Load Type");
					System.out.println("1. Regular");
					System.out.println("2. DITO LEVEL-UP");
					System.out.println("3. Back");
					if(!scanner.hasNextInt()){
								System.out.println("Invalid Input, Enter a Number from 1-3, Try Again");
								scanner.next();
								continue;
							}
							loadt=scanner.nextInt();
							System.out.println("*********************************************************");
							if(loadt==1){
								promo="Regular";
								System.out.println("Bl: "+balance);
								System.out.println("Enter 0 to Cancel");
								System.out.println("Enter The Amount of Regular Load You Want to Buy");
								if(!scanner.hasNextInt()){
									System.out.println("Invalid Input, Enter a Whole Number, Try Again");
									scanner.next();
									continue;
								}
								price=scanner.nextInt();
								System.out.println("***************************************");
								if(price==0){
									continue;
								}
								else if (price<balance){
									balance-=price;
									break;
								}
								else{
									System.out.println("Insufficient Balance, Try Again");
									System.out.println("***************************************");
									continue;
								}
							}
							
							else if(loadt==2){
								promo="Dito Level-Up";
								System.out.println("BL: "+balance);
								System.out.println("Select DITO LEVEL-UP you want to purchase");
								System.out.println("1. DITO LEVEL-UP 99");
								System.out.println("2. DITO LEVEL-UP 109");
								System.out.println("3. DITO LEVEL-UP 129");
								System.out.println("4. DITO LEVEL-UP 199");
								System.out.println("5. DITO LEVEL-UP 299");
								System.out.println("6. Back");
								if(!scanner.hasNextInt()){
									System.out.println("Invalid Input, Enter a Number from 1-6, Try Again");
									scanner.next();
									continue;
								}
								int Dito=scanner.nextInt();
								System.out.println("***************************************");
								if (Dito<1 || Dito>6){
									System.out.println("Invalid Input, Enter a Number from 1-6, Try Again");
									continue;
								}
								else if(Dito==6){
									continue;
								}
								
								switch(Dito){
									case 1:
									price=99;
									break;
									case 2:
									price=109;
									break;
									case 3:
									price=129;
									break;
									case 4:
									price=199;
									break;
									case 5:
									price=299;
									break;
								}					
								if (price<balance){
								 balance-=price;
									break;
								}
								else{
									System.out.println("Insufficient balance, try again");
								 System.out.println("*********************************************************");
								 continue;						
								}
							}
							else if(loadt==3){
								amount=0;
								price=0;
								break;
							}						
							else {
								System.out.println("Invalid Input, Enter a Number from 1-3 , Try Again");
								continue;
							}
						}
					}
					else{
								System.out.println("The mobile number is not for this Telco");
								continue;
					}						
				}							
			}
					
		else if(buy==3){
			System.out.println("Thank you for using our system");
			return;
		}
		else{
			System.out.println("Invalid Input, Enter a Number from 1-3, Try Again");
			continue;
		}
		if(price>0){
				System.out.println("******** RECEIPT ***************************************  ");
				System.out.println(" ");
				System.out.println("Order No:             "+ON);
				System.out.println("Date:                 "+Dt);
				System.out.println("Number:               "+ number);
				System.out.println("Telco:                " +T);
				System.out.println("Promo:                " +promo +" "+ price);
				System.out.println(" ");
				ON+=1;
				}
				
				if (price>0 || amount>0){
					System.out.println("*********************************************************");
					System.out.println("--- Do you want to buy more? ---");
					System.out.println("--    Enter 1, to buy more    --");
					System.out.println("--      Enter 2, to exit      --");
					if (!scanner.hasNextInt()){
					System.out.println("Invalid input, please enter a number.");
					scanner.next();
					continue;                
					}
					int back=scanner.nextInt();
					if (back==1){
					    	continue;
					    	}
					        else if (back ==2){
					        	System.out.println("*********************************************************");
					    		System.out.println("Thank you for using our system");
					    		return;
					    	}
					    	else{
					    		System.out.println("*********************************************************");
					    		System.out.println("Invalid Input, Aumatically Go Back To The Beginning");
					    		continue;
					    	}
				}
				else{
					continue;
				}									
		}	
	}
}