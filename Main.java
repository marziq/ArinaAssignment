package Arina;
import java.util.Scanner;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        Scanner input = new Scanner(System.in);
        BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));
        boolean isContinue = true;
        boolean isExist = false;
        int chooseAgent = 0;
        String customerName;
        int customerIndex = 0;
        Customers[] customers = new Customers[50];
        Products[] products = new Products[5];
        Bookings bookings = new Bookings();
        Agents[] agents = new Agents[3];

        for(int i = 0;i < customers.length; i++)
            customers[i] = new Customers();
        //customers
        customers[0] = new Customers("Aishah Humairah", "+6016915463", "Tanjong Malim");
        customers[1] = new Customers("John Pork", "+6060916594", "Sydney");
        customers[2] = new Customers("Taylor Swift", "+6026650180", "KL East");
        customers[3] = new Customers("Michael Jacky", "+6076276684", "London");
        //agents
        agents[0] = new Agents("Georgina Smith", "+6054864532", "Luxemborg");
        agents[1] = new Agents("Maya Al-Karim", "+6083901850", "Sudan");
        agents[2] = new Agents("Nur Fareeha", "+6089313598", "Singapore");
        //products
        products[0] = new Products(1,"Standard Economy Seat", 100);
        products[1] = new Products(2,"Standard Economy Window Seat", 200);
        products[2] = new Products(3,"Standard Business Seat", 760);
        products[3] = new Products(4, "Standard Business Windows Seat", 900);
        products[4] = new Products(5, "Executive First Class Seat", 3000);

        //main loop
        while(isContinue){
            System.out.println("\nWelcome to Sobhan Airline booking");
            System.out.println("\nChoose agent: ");
            for(int i = 0; i < Agents.getNumAgents(); i++)
                System.out.println("   "+ (i+1) + ". " + agents[i].getName());
            do {
                System.out.print("Choose agent: ");
                chooseAgent = input.nextInt();
                if(chooseAgent > Agents.getNumAgents())
                    System.out.println("An Error Occured, Please Enter Again");
            }while(chooseAgent > Agents.getNumAgents());
            chooseAgent--;
            System.out.print("Enter Customer name: ");
            bookings.setCustomerName(entry.readLine());

            for(int i = 0; i < Customers.getCustomersCount(); i++)
            if(bookings.getCustomerName().equalsIgnoreCase(customers[i].getName())){
                isExist = true;
                break;
            }
            else
                isExist = false;

            if(isExist){
                System.out.println("Customer is a registered customer\n");
                for(int i = 0; i <= Customers.getCustomersCount(); i++)
                    if(bookings.getCustomerName().equalsIgnoreCase(customers[i].getName())){
                        System.out.println("Name: " + customers[i].getName());
                        System.out.println("Contact no: " + customers[i].getContactNumber());
                        System.out.println("Address: " + customers[i].getAddress());
                        break;
                    }
            }
            else{
                System.out.println("Customer is not yet registered\n");
                System.out.print("Enter Name: ");
                customerName = entry.readLine();
                System.out.print("Enter Contact No: ");
                String customerContact = entry.readLine();
                System.out.print("Enter Address: ");
                String customerAddress = entry.readLine();
                System.out.println("New Customer successfully added\n");
                customers[Customers.getCustomersCount()] = new Customers(customerName,customerContact,customerAddress);
            }

            System.out.print("Make new booking?(Y/N): ");
            char userChoice = input.next().charAt(0);
            switch(userChoice){
                case 'y': case 'Y':break;
                default: continue;
            }

            System.out.println("Available packages: ");
            for(int i = 0;i < Products.getProductCounts(); i++)
                System.out.printf("     %d. %-33s RM%.2f\n", i+1, products[i].getProductName(), products[i].getProductPrice());

            System.out.print("Choose package: ");
            bookings.setProductCode(input.nextInt());
            int customerPackage = bookings.getProductCode() - 1;
            System.out.print("Enter Quantity: ");
            bookings.setQuantity(input.nextInt());

            //calculate total amount
            double totalAmount = bookings.getQuantity()*products[customerPackage].getProductPrice();

            System.out.println("You have chosen " + products[customerPackage].getProductName() + " for " + bookings.getQuantity() + " pax");
            System.out.printf("Amount of package is RM%.2f\n", totalAmount);

            for(int i =0; i < Customers.getCustomersCount(); i++)
                if(bookings.getCustomerName().equalsIgnoreCase(customers[i].getName()))
                    customerIndex = i;

            customers[customerIndex].updateTotalPurchase(totalAmount); //update customer total amount
            agents[chooseAgent].updateCommission(totalAmount*agents[chooseAgent].getRate()); // add commision
            System.out.print("Another booking(Y/N) ? ");
            char ans = input.next().charAt(0);
            switch(ans){
                case 'y': case 'Y': isContinue = true;break;
                default: isContinue = false;
            }
        }
        System.out.println("\nSummary report by agent\n");
        System.out.println("     Name of Agent\t Commision");
        System.out.println("----------------------------------");
        for(int i = 0; i < Agents.getNumAgents(); i++)
            System.out.printf("     %d. %-20s RM%.2f\n", i+1, agents[i].getName(), agents[i].getCommission());
    }
}
